package com.example.exercises;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		Function<ContinentCity,Integer> populationExtractor =
			cc -> cc.city().getPopulation();	
		var highPopulatedCityOfEachContinent =
		countryDao.findAllCountries()
		          .stream()
		          .map( 
		              country 
		              -> 
		              country.getCities()
		                     .stream()
		                     .map(city -> new ContinentCity(country.getContinent(),city))
		                     .toList()
		           )
		           .flatMap(List::stream)
		           .collect(
		        		Collectors.groupingBy(ContinentCity::continent, Collectors.maxBy(Comparator.comparing(populationExtractor)))
		        	);
		highPopulatedCityOfEachContinent.forEach((continent,continentCity)->{
			System.out.println(String.format("%16s: %s,%d",continent,continentCity.get().city().getName(),continentCity.get().city().getPopulation()));
		});
	}

}

record ContinentCity(String continent, City city) {}