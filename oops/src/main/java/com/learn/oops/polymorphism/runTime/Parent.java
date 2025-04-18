package com.learn.oops.polymorphism.runTime;

//Java Program for Method Overriding

//Class 1
//Helper class
class Parent {

	// Method of parent class
	void Print() {
		System.out.println("parent class");
	}
}

//Class 2
//Helper class
class subclass1 extends Parent {

	// Method
	void Print() {
		System.out.println("subclass1");
	}
}

//Class 3
//Helper class
class subclass2 extends Parent {

	// Method
	void Print() {
		System.out.println("subclass2");
	}
}
