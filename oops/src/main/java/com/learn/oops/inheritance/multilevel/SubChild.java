package com.learn.oops.inheritance.multilevel;

import com.learn.oops.inheritance.single.Child;

/**
 * The Class SubChild inherits methods at different levels.
 * 
 * SC -> C -> S
 */
public class SubChild extends Child {

	/**
	 * Prints the sub child.
	 */
	public void printSubChild() {

		System.out.println("This is sub child!!!");
	}
}
