package com.learn.oops.inheritance.single;

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
		Child child = new Child();

		// or can be invoked like this
		// Parent child = new Child();
		// var child = new Child();

		child.printParent();
		child.printChild();

	}

}
