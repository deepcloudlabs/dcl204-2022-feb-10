package com.example;

import static com.example.Gender.FEMALE;
import static com.example.Gender.MALE;
import static com.example.Language.C;
import static com.example.Language.CPP;
import static com.example.Language.CS;
import static com.example.Language.JAVA;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Exercise3 {

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
		ToDoubleFunction<DeveloperLanguage> toSalary =
			devLang -> devLang.developer().getSalary();	
		var developerSalaryStatisticsByLanguage = 
		developers.stream() // Stream<Developer>
		          .map((Developer developer) -> developer.getLanguages()
                      .stream()
                      .map(ProgrammingLanguage::getLanguage)
                      .map(lang -> new DeveloperLanguage(developer,lang))
                      .toList()
	           ) // Stream<List<DeveloperLanguage>>
		       .flatMap(List::stream) // Stream<DeveloperLanguage>
	           .collect(
	        	   Collectors.groupingBy(
	        		     DeveloperLanguage::language,
	        		     Collectors.summarizingDouble(toSalary)
	        	   )
	           );
		System.out.println(developerSalaryStatisticsByLanguage);		          
	}

}

record DeveloperLanguage (Developer developer,Language language) {}
