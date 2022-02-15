package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	public static void main(String[] args) {
		// Take a list of wild animals
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		Predicate<Animal> isPet = Pet.class::isInstance;
		Predicate<Animal> isWild = isPet.negate();
		var wildAnimals = 
		animals.stream()
		       .filter(isWild)
		       .toList();
		System.out.println(wildAnimals);
	}
}
