package com.learn.oops.abstraction.interfaces;

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

		// Interfaces provide 100% abstraction
		SendMessage sms = new SMS();

		System.out.println(sms.sendMessage("This is a text message to be sent via SMS"));

		SendMessage email = new EMail();

		System.out.println(email.sendMessage("This is a text message to be sent via SMS"));

	}
}
