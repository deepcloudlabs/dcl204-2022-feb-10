package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;
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
	public static void main(String[] args) {
		// Group the animals by their number of legs
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		var animalsByLegNumbers =
		animals.stream()
		       .collect(Collectors.groupingBy(Animal::getLegs));
		animalsByLegNumbers.forEach(
				(numOfLegs,theAnimals) 
				->
				System.out.println(numOfLegs+": "+theAnimals)
		);       
	}
}
