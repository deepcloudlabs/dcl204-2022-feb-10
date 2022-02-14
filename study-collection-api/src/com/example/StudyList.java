package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// List: 1) Allow duplicates 2) Ordered
		// Implementations: ArrayList, LinkedList
		List<Integer> numbers = new ArrayList<>(1_000_000);
		numbers.add(4);
		numbers.add(8);
		numbers.add(42);
		numbers.add(0,4);
		numbers.add(2,23);
		numbers.add(4);
		numbers.add(16);
		numbers.add(4);
		numbers.add(15);
		System.out.println(numbers);
		System.out.println(numbers.get(3));
		numbers.remove(0);
		numbers.remove(0);
		numbers.remove(0);
		numbers.remove(Integer.valueOf(8));
		System.out.println(numbers);
		Comparator<Integer> ascendingSort = Integer::compare;
		numbers.sort(ascendingSort.reversed());
		System.out.println(numbers);
		System.out.println(numbers.contains(108));
	}

}
