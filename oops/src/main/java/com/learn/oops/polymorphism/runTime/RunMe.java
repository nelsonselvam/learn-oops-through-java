package com.learn.oops.polymorphism.runTime;

public class RunMe {
	
	// Main driver method
	public static void main(String[] args) {

		// Creating object of class 1
		Parent a;

		// Now we will be calling print methods
		// inside main() method
		a = new subclass1();
		a.Print();

		a = new subclass2();
		a.Print();
	}

}
