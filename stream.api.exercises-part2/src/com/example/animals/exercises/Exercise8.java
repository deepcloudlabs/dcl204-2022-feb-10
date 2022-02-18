package com.example.animals.exercises;

import java.util.List;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise8 {
	public static void main(String[] args) {
		// Count the number of species
		var animals = List.of(
				new Cat(), 
				new Spider(), 
				new Cat("Tekir"), 
				new Fish("Free Willy"),
				new Spider(), 
				new Fish("Jaws")
		);
		var totalNumberOfSpecies = 
				animals.stream()
				       .map(Animal::getClass)
				       .map(Class::getSimpleName)
				       .distinct()
				       .count();
		System.out.println(totalNumberOfSpecies);
	}
}
