package com.example;

import java.util.List;
import java.util.function.Predicate;

public class Exercise01 {

	public static void main(String[] args) {
		var developers = List.of(
				new Developer(1965, 
			List.of(new ProgrammingLanguage(Language.CPP, 10, 14),
					new ProgrammingLanguage(Language.JAVA, 6, 4),
		            new ProgrammingLanguage(Language.C, 9, 10)
			), 24_000, 22, Gender.MALE),
				new Developer(1976, 
			List.of(new ProgrammingLanguage(Language.CS, 6, 2),
					new ProgrammingLanguage(Language.JAVA, 9, 17)					
			),20_000, 17, Gender.FEMALE),					
				new Developer(1984, 
			List.of(new ProgrammingLanguage(Language.SCALA, 7, 4),
			        new ProgrammingLanguage(Language.KOTLIN, 9, 8)					
			),18_000, 12, Gender.FEMALE)					
		);
		Predicate<ProgrammingLanguage> isJava = 
				lang -> lang.getLanguage()
				.equals(Language.JAVA);
		Predicate<Developer> knowsJava = 
				developer -> {
					return developer.getLanguages()
					                      .stream()
					                      .anyMatch(isJava);
				};
		var javaDevelopers = developers.stream()
				                       .filter(knowsJava)
				                       .toList();
	}

}
