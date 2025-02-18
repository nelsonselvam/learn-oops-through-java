package com.learn.oops.abstraction.abstractClasses;

public class RunMe {

	public static void main(String[] args) {
		
		Shape circle = new Circle("Red", 2.2);
		Shape square = new Square("Yellow", 4);

		System.out.println(circle.toString());
		System.out.println(square.toString());
	}

}
