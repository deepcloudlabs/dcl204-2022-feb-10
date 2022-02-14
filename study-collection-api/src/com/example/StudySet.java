package com.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// Set: 1) Unique 2) Un-Ordered
		// Implementations: HashSet, LinkedHashSet, TreeSet
		Comparator<Integer> ascendingSort = Integer::compare;
		Set<Integer> numbers = new TreeSet<>(ascendingSort.reversed());
		numbers.add(4);
		numbers.add(8);
		numbers.add(42);
		numbers.add(4);
		numbers.add(15);
		numbers.add(16);
		numbers.add(4);
		System.out.println(numbers);
		System.out.println(numbers.contains(108));		
//		numbers.remove(16);
//		numbers.remove(23);
//		numbers.remove(8);
//		System.out.println(numbers);
	}

}
