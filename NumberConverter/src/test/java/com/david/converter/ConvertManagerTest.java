package com.david.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.david.converter.core.ConvertManager;
import com.david.converter.core.NumberArray;
import com.david.converter.exception.OutOfScopeException;

public class ConvertManagerTest {
	NumberArray targetZero2Nine;
	NumberArray targetZero2Nine2;
	NumberArray targetOne2NintyNine;
	ConvertManager manager;
	
	@Before
	public void setUp() throws OutOfScopeException {
		int[] array = {9};
		int[] array1 = {2,3};
		int[] array2 = {10,99,0,1};
		targetZero2Nine = new NumberArray(array);
		targetZero2Nine2 = new NumberArray(array1);
		targetOne2NintyNine  = new NumberArray(array2);
	}

	@Test
	public void testZeroToNine() {
		manager = new ConvertManager(targetZero2Nine);
		String result = manager.convert();
		assertEquals("w x y z",result.trim());
	}

	@Test
	public void testZeroToNine2() {
		manager = new ConvertManager(targetZero2Nine2);
		String result = manager.convert();
		assertEquals("ad ae af bd be bf cd ce cf",result.trim());
	}
	
	@Test
	public void testBoundary(){
		manager = new ConvertManager(targetOne2NintyNine);
		String result = manager.convert();
		assertEquals("ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz",result.trim());
	}
}
