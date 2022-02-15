package com.example;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercise4 {

	public static void main(String[] args) {
		var meyveler = List.of(
		   "kiraz", "kavun", "karpuz", "kivi",
		   "şeftali", "muz", "elma", "armut",
		   "çilek"
		);
		meyveler.stream()
		        .filter(new Predicate<String>() {
		        	// anonymous class
					@Override
					public boolean test(String meyve) {
						return meyve.matches("^k[a-zşğüçöı]*z$");
					}
				})
		        .forEach(new Consumer<String>() {
                    // anonymous class
					@Override
					public void accept(String meyve) {
						System.out.println(meyve);
					}
		        });
		
		meyveler.stream()
		.filter((String meyve) -> {
				return meyve.matches("^k[a-zşğüçöı]*z$");
			}
		)
		.forEach((String meyve) -> {
				System.out.println(meyve);
		});
		
		meyveler.stream()
		.filter((meyve) -> {
			return meyve.matches("^k[a-zşğüçöı]*z$");
		}
				)
		.forEach((meyve) -> {
			System.out.println(meyve);
		});
		
		meyveler.stream()
		.filter(meyve -> {
			return meyve.matches("^k[a-zşğüçöı]*z$");
		}
				)
		.forEach(meyve -> {
			System.out.println(meyve);
		});
		
		meyveler.stream()
		        .filter(meyve -> meyve.matches("^k[a-zşğüçöı]*z$"))
	            .forEach( System.out::println);
		meyveler.stream().mapToLong(meyve -> meyve.length()).sum();
		meyveler.stream().mapToLong(String::length).sum();
	}

}
