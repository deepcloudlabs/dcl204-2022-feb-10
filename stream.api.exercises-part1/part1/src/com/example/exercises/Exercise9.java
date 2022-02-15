package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.dao.InMemoryWorldDao;
import com.example.dao.WorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise9 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by their population densities in descending order ignoring
		// zero population countries
		Collection<Country> countries = worldDao.findAllCountries();
        countries.stream()
                 .map(Country::getContinent)
                 .distinct()
                 .sorted()
                 .forEach(System.out::println);
        var lotteryNumbers =
        IntStream.range(0, 20)
        		 .parallel()
                 .mapToObj(i -> 
				        ThreadLocalRandom.current()
				                         .ints(1, 61)
				                         .parallel()
				                         .distinct()
				                         .limit(6)
				                         .sorted()
				                         .boxed()
				                         .toList()
				  ).toList();
        lotteryNumbers.forEach(System.out::println);
        var numberHistogram = 
        lotteryNumbers.stream()
                      .flatMap(List::stream)
                      .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        numberHistogram.forEach((number,count)->System.out.println(number+": "+count));
        var bins = IntStream.range(1, 61)
        		 .filter( i -> !numberHistogram.containsKey(i) )
        		 .boxed()
        		 .toList();
        System.out.println(bins);
	}

}
