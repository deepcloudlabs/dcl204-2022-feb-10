package com.example.exercises;

import java.util.Collection;

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

	}

}
