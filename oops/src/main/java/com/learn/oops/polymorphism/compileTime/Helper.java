package com.learn.oops.polymorphism.compileTime;

/**
 * The Class Helper.
 */
public class Helper {

	/**
	 * 
	 * Method Overloading:
	 * 
	 * same method name, different arguments (types as well as number of args)
	 * 
	 * 
	 */

	/**
	 * Multiply.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	// Method with 2 integer parameters
	static int Multiply(int a, int b) {
		// Returns product of integer numbers
		return a * b;
	}

	// Method 2
	/**
	 * Multiply.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the double
	 */
	// With same name but with 2 double parameters
	static double Multiply(double a, double b) {
		// Returns product of double numbers
		return a * b;
	}

}
