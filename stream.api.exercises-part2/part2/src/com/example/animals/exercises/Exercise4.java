package com.example.animals.exercises;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise4 {
	public static void main(String[] args) {
		// Take a list of 100 random animals 
		List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Willy"),
				new Spider(), new Fish("Jaws"));
		var randomAnimals =
		IntStream.range(0, 100)
		         .map( i -> ThreadLocalRandom.current()
		        		                     .nextInt(0,animals.size()))
		         .mapToObj(i -> animals.get(i))
		         .toList();
		randomAnimals.forEach(System.out::println);
	}
}
