package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class SortingExercise1 {

	public static void main(String[] args) {
		Integer numbers[] = { 42, 23, 8, 4, 15, 16 };
		System.out.println(Arrays.toString(numbers));
		Comparator<Integer> ascendingOrder = (u,v) -> u-v;
				// (u,v) -> u<=v ? -1 : +1;
		var descendingOrder = ascendingOrder.reversed();
		Arrays.sort(numbers,descendingOrder);
		System.out.println(Arrays.toString(numbers));
	}

}
