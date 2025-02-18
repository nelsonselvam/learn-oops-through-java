package com.learn.oops.abstraction.interfaces;

/**
 * 
 * This is a concrete class that implements the abstracted interface and defines
 * it's own definition.
 * 
 * 
 */
public class EMail implements SendMessage {

	@Override
	public String sendMessage(String message) {

		return "Emailing...." + message;
	}

}
