package com.learn.oops.classes;

import java.lang.reflect.InvocationTargetException;

public class RunMe {

	public static void main(String[] args) {

		// instantiating a class

		// Type 1 : using new keyword, here it invokes the 1 arg constructor.
		Car subaru = new Car("Crosstrek");

		// Type 2 : using Class.forName() method
		try {
			Class<?> c = Class.forName("Car");
			try {
				Car mercedes = (Car) c.getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				System.out.println("Oops that hits!!!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Car not found!!!");
		}

		// Type 3 : using clone() method
		try {
			Car bmw = (Car) subaru.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * So typically in the above subaru, mercedes and bmw are objects. These objects
		 * have the below
		 * 
		 * state : the attributes i.e. make, model etc. <br>
		 * behavior : the methods as well as the response of the object <br>
		 * identity : the name i.e. subaru for example <br>
		 * 
		 * 
		 */

		System.out.println(subaru.getModel());

		System.out.println(subaru);

		System.out.println(subaru.getClass());

		subaru = null;

		System.gc(); // only works when the object state is null

		System.out.println("end");

	}

}
