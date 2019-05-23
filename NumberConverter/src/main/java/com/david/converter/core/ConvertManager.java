package com.david.converter.core;

import com.david.converter.exception.OutOfScopeException;

/**
 * @author David
 * 
 * The ConvertManager do the conversion work by calling interfaces
 * 
 *
 */
public class ConvertManager {
	
	IMapper mapper = null;
	IConvertible convertible = null;
	
	public ConvertManager(IConvertible convertible){
		mapper = MappingHandler.getInstance();
		this.convertible = convertible;
	}
	
	public String convert() {
		//Convert the number array to String
		String target = convertible.convertToString();
		//Get the result by calling mapping handler
		String result = mapper.map(target);
		return result;
	}
	
	public void display(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) throws OutOfScopeException {
		int[] array = {9};
		int[] array2 = {2,3};
		int[] array3 = {0,99,1};
		NumberArray targetZero2Nine = new NumberArray(array);
		NumberArray targetZero2Nine2 = new NumberArray(array2);
		NumberArray targetOne2NintyNine = new NumberArray(array3);
		ConvertManager manager = new ConvertManager(targetOne2NintyNine);
		String result = manager.convert();
		System.out.println(result);
	}
}
