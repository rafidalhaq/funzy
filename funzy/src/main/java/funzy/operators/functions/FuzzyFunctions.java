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
package funzy.operators.functions;


/**
 * Implementation of a fuzzy Functions factory.
 * 
 * @author <a href="romain.rouvoy+funzy@gmail.com">Romain Rouvoy</a>
 * @version $Revision$
 */
public final class FuzzyFunctions {
	private static final Double CONST_LITTLE = 1.3;
	private static final Double CONST_SLIGHTLY = 1.7;
	private static final Double CONST_VERY = 2.0;
	private static final Double CONST_EXTREMELY = 3.0;
	private static final Double CONST_VERY_VERY = 4.0;
	private static final Double CONST_SOMEWHAT = 0.5;

	private FuzzyFunctions() {
	}

	public static final FuzzyFunction<Double> newNotFunction() {
		return new FuzzyFunctionNot();
	}

	public static final FuzzyFunction<Double> newMaxFunction() {
		return new FuzzyFunctionMax();
	}

	public static final FuzzyFunction<Double> newMinFunction() {
		return new FuzzyFunctionMin();
	}

	public static final FuzzyFunction<Double> newProductFunction() {
		return new FuzzyFunctionProduct();
	}

	public static final FuzzyFunction<Double> newPowFuzzyFunction(
			final double exponent) {
		return new FuzzyFunctionPow(exponent);
	}

	public static final FuzzyFunction<Double> newLittleFunction() {
		return newPowFuzzyFunction(CONST_LITTLE);
	}

	public static final FuzzyFunction<Double> newSlightlyFunction() {
		return newPowFuzzyFunction(CONST_SLIGHTLY);
	}

	public static final FuzzyFunction<Double> newVeryFunction() {
		return newPowFuzzyFunction(CONST_VERY);
	}

	public static final FuzzyFunction<Double> newExtremelyFunction() {
		return newPowFuzzyFunction(CONST_EXTREMELY);
	}

	public static final FuzzyFunction<Double> newVeryVeryFunction() {
		return newPowFuzzyFunction(CONST_VERY_VERY);
	}

	public static final FuzzyFunction<Double> newSomewhatFunction() {
		return newPowFuzzyFunction(CONST_SOMEWHAT);
	}
	
	public static FuzzyFunction<Double> AND = newMinFunction();
	public static FuzzyFunction<Double> OR = newMaxFunction();
	public static FuzzyFunction<Double> NOT = newNotFunction();
	public static FuzzyFunction<Double> LITTLE = newLittleFunction();
	public static FuzzyFunction<Double> SLIHTLY = newSlightlyFunction();
	public static FuzzyFunction<Double> VERY = newVeryFunction();
	public static FuzzyFunction<Double> EXTREMELY = newExtremelyFunction();
	public static FuzzyFunction<Double> VERYVERY = newVeryVeryFunction();
	public static FuzzyFunction<Double> SOMEWHAT = newSomewhatFunction();
}
