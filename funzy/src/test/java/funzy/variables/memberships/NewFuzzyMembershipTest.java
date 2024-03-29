// The MIT License - Copyright (c) 2007 Universitetet i Oslo

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE. 
package funzy.variables.memberships;

import static funzy.literals.SimpleDegree.LOW;
import static funzy.variables.Variable.variable;
import static funzy.variables.memberships.FuzzyMembership.newFuzzyMembership;
import static funzy.variables.memberships.PointMembership.newPoint;

import org.junit.Before;
import org.junit.Test;

import funzy.literals.SimpleDegree;
import funzy.variables.Variable;

/**
 * Test cases for the membership functions.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public class NewFuzzyMembershipTest {
	private Variable<SimpleDegree> variable;

	@Before
	public void setup() {
		variable = variable(SimpleDegree.class, .0, 10.0);
	}

	@Test
	public void fuzzyMembership() {
		variable.add(LOW, newFuzzyMembership(newPoint(0.0, 0.0),
				newPoint(3.0, 1.0), newPoint(6.0, 0.0), newPoint(9.0, 1.0),
				newPoint(10.0, 1.0)));
	}

	@Test
	public void inverseFuzzyMembership() {
		variable.add(LOW, newFuzzyMembership(newPoint(0.0, 1.0),
				newPoint(3.0, 0.0), newPoint(6.0, 1.0), newPoint(9.0, 0.0),
				newPoint(10.0, 0.0)));
	}

	@Test(expected = IllegalMembershipException.class)
	public void unorderedFuzzyMembership() {
		variable.add(LOW,
				newFuzzyMembership(newPoint(0.0, 0.0), newPoint(6.0, 1.0), newPoint(3.0,
						0.0), newPoint(9.0, 1.0), newPoint(10.0, 1.0)));
	}

//	@Test(expected = IllegalMembershipException.class)
	public void outOfCeilRangeFuzzyMembership() {
		variable.add(LOW,
				newFuzzyMembership(newPoint(0.0, 0.0), newPoint(6.0, 2.0), newPoint(3.0,
						0.0), newPoint(9.0, 1.0), newPoint(10.0, 1.0)));
	}

//	@Test(expected = IllegalMembershipException.class)
	public void outOfFloorRangeFuzzyMembership2() {
		variable.add(LOW, newFuzzyMembership(newPoint(0.0, 0.0),
				newPoint(6.0, -1.0), newPoint(3.0, 0.0), newPoint(9.0, 1.0),
				newPoint(10.0, 1.0)));
	}

//	@Test(expected = IllegalMembershipException.class)
	public void outOfMinRangeFuzzyMembership() {
		variable.add(LOW,
				newFuzzyMembership(newPoint(-2.0, 0.0), newPoint(6.0, 2.0), newPoint(3.0,
						0.0), newPoint(9.0, 1.0), newPoint(10.0, 1.0)));
	}

//	@Test(expected = IllegalMembershipException.class)
	public void outOfMaxRangeFuzzyMembership2() {
		variable.add(LOW,
				newFuzzyMembership(newPoint(0.0, 0.0), newPoint(6.0, 2.0), newPoint(3.0,
						0.0), newPoint(9.0, 1.0), newPoint(11.0, 1.0)));
	}
}
