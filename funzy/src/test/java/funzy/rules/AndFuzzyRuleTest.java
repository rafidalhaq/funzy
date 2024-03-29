package funzy.rules;

import static funzy.HashMapOfMap.newHashMapOfMap;
import static funzy.rules.FuzzyRule.iff;
import static funzy.rules.conditions.FuzzyIs.is;
import static funzy.rules.conditions.FuzzyOperator.test;
import static funzy.rules.functions.FuzzyAssigners.VERY;
import static funzy.rules.functions.FuzzyConditions.AND;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import funzy.MapOfMap;

/**
 * Test of an AND fuzzy rule.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class AndFuzzyRuleTest {
    private static final String INPUT = "input";
    private static final String OUTPUT = "output";
    private static final String LOW = "low";
    private static final String MEDIUM = "medium";
    private static final String HIGH = "high";

    private FuzzyRule<String, String> rule;
    private MapOfMap<String, String, Double> input, output;

    @Before
    public void setup() {
        rule = iff(test(AND, is(INPUT, LOW), is(INPUT, MEDIUM)));
        input = newHashMapOfMap();
        output = newHashMapOfMap();
    }

    @Test
    public void ruleFits1() {
        rule.then(OUTPUT, HIGH).evaluate(
                input.put(INPUT, LOW, 1.0).put(INPUT, MEDIUM, 1.0), output);
        assertEquals(1.0, output.get(OUTPUT, HIGH));
    }

    @Test
    public void ruleFitsDot5() {
        rule.then(OUTPUT, HIGH).evaluate(
                input.put(INPUT, LOW, .5).put(INPUT, MEDIUM, 1.0), output);
        assertEquals(.5, output.get(OUTPUT, HIGH));
    }

    @Test
    public void ruleFitsVery() {
        rule.then(OUTPUT, HIGH, VERY).evaluate(
                input.put(INPUT, LOW, .25).put(INPUT, MEDIUM, 1.0), output);
        assertEquals(.5, output.get(OUTPUT, HIGH));
    }

    @Test
    public void ruleFitsTwo() {
        rule.then(OUTPUT, HIGH, VERY).then(OUTPUT, LOW).evaluate(
                input.put(INPUT, LOW, .25).put(INPUT, MEDIUM, 1.0), output);
        assertEquals(.5, output.get(OUTPUT, HIGH));
        assertEquals(.25, output.get(OUTPUT, LOW));
    }

    @Test
    public void ruleDoesNotFit() {
        rule.then(OUTPUT, HIGH).evaluate(
                input.put(INPUT, LOW, .0).put(INPUT, MEDIUM, 1.0), output);
        assertTrue("Rule output should be empty", output.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void ruleVariableError() {
        rule.then(OUTPUT, HIGH).evaluate(
                input.put(OUTPUT, LOW, .0).put(INPUT, MEDIUM, 1.0), output);
    }

    @Test(expected = RuntimeException.class)
    public void ruleLiteralError() {
        rule.then(OUTPUT, HIGH).evaluate(
                input.put(INPUT, HIGH, .0).put(INPUT, MEDIUM, 1.0), output);
    }
}
