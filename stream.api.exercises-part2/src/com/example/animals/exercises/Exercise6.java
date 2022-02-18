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
public class Exercise6 {
	private static final BiConsumer<Integer, List<Animal>> printAnimalGroups = (count, list) -> System.out
			.printf("%d: %s\n",count,list);

	public static void main(String[] args) {
		// Group the animals by their number of legs
		var animals = List.of(
				new Cat(), 
				new Spider(), 
				new Cat("Tekir"), 
				new Fish("Free Willy"),
				new Spider(), 
				new Fish("Jaws")
		);
		var groupedAnimals = animals.stream().collect(Collectors.groupingBy(Animal::getLegs));
		groupedAnimals.forEach(printAnimalGroups);
	}
}
