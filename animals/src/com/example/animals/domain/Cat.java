package com.example.animals.domain;

public class Cat extends Animal implements Pet {
	private String name;

	public Cat() {
		this("Tekir");
	}

	public Cat(String name) {
		super(4);
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		System.out.println(
			  String.format("%s is playing now...", name)
		);		
	}

	@Override
	public void eat() {
		System.out.println(
			String.format("%s is eating now...", name)
		);		
	}

}
