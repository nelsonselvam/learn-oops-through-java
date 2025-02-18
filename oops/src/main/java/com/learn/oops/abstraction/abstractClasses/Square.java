package com.learn.oops.abstraction.abstractClasses;

/**
 * The Class Square.
 */
public class Square extends Shape {

	/** The side. */
	double side;

	/**
	 * Instantiates a new square.
	 *
	 * @param color the color
	 * @param side  the side
	 */
	public Square(String color, double side) {
		// calling Shape constructor
		super(color);
		System.out.println("Square constructor called");
		this.side = side;
	}

	/**
	 * Area.
	 *
	 * @return the double
	 */
	@Override
	double area() {
		return side * side;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Square color is " + super.getColor() + " and area is : " + area();
	}

}
