package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        var directorMovieCounts =
        movies.stream() // Stream<Movie>
              .map(Movie::getDirectors) // Stream<List<Director>>
              .peek(System.out::println)
              .flatMap(List::stream) // Stream<Director>
              .peek(System.out::println)
              .collect(
            	  Collectors.groupingBy(
            		  Function.identity(),
            		  Collectors.counting()
            	  )
                );
        directorMovieCounts.forEach( (director,count) -> 
        	System.out.println(
        	  String.format("%24s: %-3d",director.getName(),count)
        	)
        );
        System.out.println("Movies with multiple directors");
        movies.stream()
              .filter( movie -> movie.getDirectors().size() > 1)
              .forEach(System.out::println);
        var drama = movieService.findGenreByName("Drama");
        var comedy = movieService.findGenreByName("Comedy");
        Predicate<Movie> isDrama = 
        		movie -> movie.getGenres().contains(drama);
		Predicate<Movie> isComedy = 
				movie -> movie.getGenres().contains(comedy);
	    System.out.println("Drama and Comedy Movies");
        movies.stream()
              .filter(isDrama.and(isComedy))
              .forEach( System.out::println);
              
	}

}
