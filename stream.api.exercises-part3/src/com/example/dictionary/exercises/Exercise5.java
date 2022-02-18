package com.example.dictionary.exercises;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {
	private static final BiConsumer<Integer, List<String>> printEntry = (key, value) -> System.out.format("%c : %d\n",
			key, value.size());

	public static void main(String[] args) throws Exception {
		var words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Count the vowels used in words
		words.stream()
		     .flatMap(word -> word.chars().boxed().map(c -> new Pair(c, word)))
			 .collect(groupingBy(Pair::wowel, mapping(Pair::word, toList())))
			 .forEach(printEntry);
	}

}

record Pair(Integer wowel,String word) {}