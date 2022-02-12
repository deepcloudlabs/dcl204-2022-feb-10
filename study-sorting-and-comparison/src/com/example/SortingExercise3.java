package com.example;

import java.util.Comparator;
import java.util.List;

public class SortingExercise3 {

	public static void main(String[] args) {
		List<Integer> numbers= List.of(42, 23, 8, 4, 15, 16 );
		System.out.println(numbers);
		Comparator<Integer> ascendingOrder = (u,v) -> u-v;
		var descendingOrder = ascendingOrder.reversed();
		var sortedNumbers = numbers.stream().sorted(descendingOrder).toList();
		System.out.println(sortedNumbers);
	}

}
