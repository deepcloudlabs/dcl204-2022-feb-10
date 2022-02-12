package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExercise2 {

	public static void main(String[] args) {
		List<Integer> numbers= new ArrayList<>(List.of(42, 23, 8, 4, 15, 16 ));
		System.out.println(numbers);
		Comparator<Integer> ascendingOrder = (u,v) -> u-v;
		var descendingOrder = ascendingOrder.reversed();
		numbers.sort(descendingOrder);
		System.out.println(numbers);
	}

}
