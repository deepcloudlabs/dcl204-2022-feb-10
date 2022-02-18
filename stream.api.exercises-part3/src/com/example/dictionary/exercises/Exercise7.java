package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise7 {

	public static void main(String[] args) throws Exception {
		var words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the longest word in the dictionary
		words.stream()
		     .sorted(Comparator.comparing(String::length).reversed()).findFirst()
			 .ifPresent(System.out::println);
	}

}
