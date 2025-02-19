package com.learn.oops.inheritance.multilevel;

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

		//
		SubChild subChild = new SubChild();

		// or can be invoked like this
		// Parent child = new Child();
		// var child = new Child();

		subChild.printParent();
		subChild.printChild();
		subChild.printSubChild();

	}
}
