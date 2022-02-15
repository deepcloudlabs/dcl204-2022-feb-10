package com.example;

import static com.example.Gender.*;
import static com.example.Language.*;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise2 {

	public static void main(String[] args) {
		var developers = List.of(
				new Developer(1965, 
			List.of(new ProgrammingLanguage(CPP, 10, 14),
					new ProgrammingLanguage(JAVA, 6, 4),
		            new ProgrammingLanguage(C, 9, 10)
			), 24_000, 22, MALE),
				new Developer(1976, 
			List.of(new ProgrammingLanguage(CS, 6, 2),
					new ProgrammingLanguage(JAVA, 9, 17)					
			),20_000, 17, FEMALE),					
				new Developer(1984, 
			List.of(new ProgrammingLanguage(CS, 7, 4),
			        new ProgrammingLanguage(CPP, 9, 8)					
			),18_000, 12, FEMALE)					
		);
		Predicate<Developer> knowsJava = 
			developer -> developer.getLanguages()
			                      .stream()
			                      //.map(ProgrammingLanguage::getLanguage)
			                      .map(progLang -> progLang.getLanguage())
			                      .anyMatch(JAVA::equals);
		var javaDeveloperSalaryStatistics = developers.stream()
				                       .filter(knowsJava)
			.collect(Collectors.summarizingDouble(
					Developer::getSalary));
		System.out.println(javaDeveloperSalaryStatistics);
	}

}
