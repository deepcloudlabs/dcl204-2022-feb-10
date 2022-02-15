package com.example;

import java.util.List;

public class Developer {
	private int birthYear;
	private List<ProgrammingLanguage> languages;
	private double salary;
	private int experience;
	private Gender gender;

	public Developer(int birthYear, List<ProgrammingLanguage> languages, double salary, int experience, Gender gender) {
		this.birthYear = birthYear;
		this.languages = languages;
		this.salary = salary;
		this.experience = experience;
		this.gender = gender;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<ProgrammingLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<ProgrammingLanguage> languages) {
		this.languages = languages;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Developer [birthYear=" + birthYear + ", languages=" + languages + ", salary=" + salary + ", experience="
				+ experience + ", gender=" + gender + "]";
	}

}
