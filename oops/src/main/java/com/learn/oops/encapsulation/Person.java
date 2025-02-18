package com.learn.oops.encapsulation;

public class Person {

	// Encapsulating the name and age
	// only approachable and used using
	// methods defined
	private String name;

	private int age;
	
	// Getters and Setters ensure data integrity.

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Abstraction : as the logic is hidden.
	 * 
	 * @return
	 */
	public void getPersonDetail() {

		System.out.println(this.name + " is " + this.age + " years old.");

	}

}
