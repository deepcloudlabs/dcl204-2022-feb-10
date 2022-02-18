package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {

	public static void main(String[] args) throws Exception {
		var words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Find the words starting with letters a to m
		words.stream()
		     .takeWhile(line -> line.matches("^[a-m].*$"))
		     .forEach(System.out::println);
	}

}
