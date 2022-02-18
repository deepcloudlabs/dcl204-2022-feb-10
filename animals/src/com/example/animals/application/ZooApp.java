package com.example.animals.application;

import java.util.List;
import java.util.function.Consumer;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

@SuppressWarnings("unused")
public class ZooApp {

	public static void main(String[] args) {
		List<Animal> zooAnimals = List.of(
				new Spider(),
				new Cat(),
				new Fish("Free Willy"),
				new Spider(),
				new Cat("Garfield"),
				new Fish("Jaws"),
				new Spider()
		);
		Animal myAnimal = new Spider();
		Cat cat = (Cat) myAnimal;
		
		// Imperative
		for (var animal : zooAnimals) { //external loop
			animal.walk();
			animal.eat();
			if (animal instanceof Pet pet) {
				pet.play();
			}
		}
		// Functional -> Declarative
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::eat;
		Consumer<Animal> playIfPet = animal -> { 
			if (animal instanceof Pet pet) pet.play(); 
		}; 
		// internal loop
		zooAnimals.forEach(walk.andThen(eat).andThen(playIfPet));
	}

}
