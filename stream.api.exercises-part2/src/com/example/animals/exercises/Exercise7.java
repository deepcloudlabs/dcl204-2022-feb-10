package com.example.animals.exercises;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {
	private static final BiConsumer<Class<?>, Long> printAnimalsGroups = (clazz, count) -> System.out
			.println(clazz.getSimpleName() + ": " + count);

	public static void main(String[] args) {
		// Count the number of animals in each species
		var animals = List.of(
				new Cat(), 
				new Spider(), 
				new Cat("Tekir"), 
				new Fish("Free Willy"),
				new Spider(), 
				new Fish("Jaws")
		);
		var groupedAnimals = 
			animals.stream()
			   	   .collect(Collectors.groupingBy(Animal::getClass, Collectors.counting()));
		groupedAnimals.forEach(printAnimalsGroups);
	}
}
