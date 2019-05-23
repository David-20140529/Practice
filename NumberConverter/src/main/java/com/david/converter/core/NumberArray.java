package com.david.converter.core;

import com.david.converter.exception.OutOfScopeException;

/**
 * @author David
 *
 */
public class NumberArray implements IConvertible {

	private int[] numbers;
	
	public NumberArray(int[] numbers) throws OutOfScopeException {
		//Should there any unexpected number, exception should be thrown
		for (int number : numbers) {
			if (number < 0 || number > 99) {
				throw new OutOfScopeException();
			}	
		}
		
		this.numbers = numbers;
	}
	
	/**
	 * Convert the int array to string before mapping
	 */
	public String convertToString() {
		final StringBuilder builder = new StringBuilder();
		for (int number : numbers) {
			builder.append(number);
		}
		return builder.toString();
	}
}
