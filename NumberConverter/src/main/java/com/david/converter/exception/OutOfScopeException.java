package com.david.converter.exception;

/**
 * @author David
 * Special exception
 */
public class OutOfScopeException extends Exception {
	private static final long serialVersionUID = 1L;

	public OutOfScopeException() {
		super("Number is less than 0 or greater than 99");
		System.out.println("Another commit from master");
    }

}
