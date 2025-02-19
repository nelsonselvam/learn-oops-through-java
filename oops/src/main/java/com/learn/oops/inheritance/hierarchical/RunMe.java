package com.learn.oops.inheritance.hierarchical;

/**
 * The Class RunMe.
 */
public class RunMe {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		var dc1 = new DerivedClass1();
		dc1.printBase();		// access to base class method
		dc1.printDerived1();

		var dc2 = new DerivedClass2();
		dc2.printBase();		// access to base class method
		dc2.printDerived2();

		var dc3 = new DerivedClass3();
		dc3.printBase();		// access to base class method
		dc3.printDerived3();
	}

}
