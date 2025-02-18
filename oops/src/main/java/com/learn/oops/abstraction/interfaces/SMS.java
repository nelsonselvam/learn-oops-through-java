/**
 * 
 */
package com.learn.oops.abstraction.interfaces;

/**
 * 
 */
public class SMS implements SendMessage {

	@Override
	public String sendMessage(String message) {
		
		return "SMSing...." + message;
	}

}
