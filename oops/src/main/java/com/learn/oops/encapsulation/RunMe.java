package com.learn.oops.encapsulation;

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

		// person object created
		Person p = new Person();

		/**
		 * 
		 * 
		 * encapsulation is achieved by restricting direct access to the name and age
		 * fields of the Person class
		 * 
		 */
		p.setName("John");
		p.setAge(30);

		// Using methods to get the values from the
		// variables
		System.out.println("Name: " + p.getName());
		System.out.println("Age : " + p.getAge());
		p.getPersonDetail();

	}

}
