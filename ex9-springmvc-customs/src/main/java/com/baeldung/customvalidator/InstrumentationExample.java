package com.baeldung.customvalidator;

import java.util.ArrayList;
import java.util.List;

public class InstrumentationExample {

	public static void main(String[] arguments) {
		
		
		
		final byte b =1;
		int value =2;
		switch(value) {
		case b: System.out.println("A");
		break;
		case 2: System.out.println("B");
		case 3: System.out.println("C");
		default: System.out.println("D");
		break;
		}
		
		
	}
}