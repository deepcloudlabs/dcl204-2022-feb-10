package com.example;

import java.util.ArrayList;
import java.util.List;

public class StudyWrapperClasses {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(42);
		list.add(42);
		list.add(42);
		// Auto-Boxing 
		Integer x = Integer.valueOf(42); 
		// Object header: 12B + 4B = 16B
		int y= 42; // 4B
		x = x + 1;
		x = Integer.valueOf(x.intValue() + 1);
		y = y + 1;
	}

}

class Country {
	Long population;
	Double surfaceArea;
}
