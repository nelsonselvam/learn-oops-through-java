package com.learn.oops.classes;

import java.util.Objects;

/**
 * 
 * A class is a blueprint for an object. It is like a template that is used to
 * create objects, yeah, the classic cookie cutter.
 * 
 * <br>
 * Every class in Java is directly or indirectly derived from the Object class.
 * If a class does not extend any other class then it is a direct child class of
 * the Java Object class and if it extends another class then it is indirectly
 * derived. <br>
 * <br>
 * The Object class provides several methods such as toString(),equals(),
 * hashCode(), and many others.
 * 
 * 
 */
public class Car implements Cloneable {

	// Data Members (also instance variables)
	int modelId;

	String model;

	String make;

	int year;

	// Data Members

	// Methods

	// Constructors are methods

	/**
	 * Explicit No Arg Constructor which Java provides by default if hasn't been
	 * specified. Typically returns an instance of a class when invoked.
	 * 
	 * 
	 */
	public Car() {

	}

	/**
	 * 
	 * There can be n number of constructors as Java Supports Constructor
	 * Overloading.
	 * 
	 * Below is a single arg constructor.
	 * 
	 * @param model
	 */
	public Car(String model) {
		this.model = model;
	}

	/**
	 * Explicit All Args Constructor Doesn't return anything
	 * 
	 * 
	 * @param modelId
	 * @param model
	 * @param make
	 * @param year
	 */
	public Car(int modelId, String model, String make, int year) {
		super(); // to invoke any parent class constructor
		this.modelId = modelId;
		this.model = model;
		this.make = make;
		this.year = year;
	}

	/**
	 * @return the modelId
	 */
	public int getModelId() {
		return modelId;
	}

	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override // this method is provided by Object
	protected Object clone() throws CloneNotSupportedException {
		// Super() keyword refers to parent class
		return super.clone();
	}

	/**
	 * The toString() provides a String representation of an object and is used to
	 * convert an object to a String.
	 * 
	 */
	@Override // this method is provided by Object
	public String toString() {
		return "Car [modelId=" + modelId + ", model=" + model + ", make=" + make + ", year=" + year + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * It returns a hash value that is used to search objects in a collection. The
	 * main advantage of saving objects based on hash code is that searching becomes
	 * easy.
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(make, model, modelId, year);
	}

	/**
	 * The equals() method compares the given object with the current object.
	 * 
	 * hashCode-equals contract :equal objects must have equal hash codes whenever
	 * hashCode() is overridden, then the equals() method should also be overridden
	 * and vice versa.
	 * 
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		return Objects.equals(make, other.make) && Objects.equals(model, other.model) && modelId == other.modelId
				&& year == other.year;
	}

	/**
	 * 
	 * Called before GC. Example use cases: dispose of system resources, perform
	 * clean-up activities and minimize memory leaks.
	 * 
	 */
	@Override
	protected void finalize() {
		System.out.println("finalize method called");
	}
}
