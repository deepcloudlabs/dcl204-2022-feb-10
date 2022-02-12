package com.example;

public class StudyProperties {
	public static void main(String[] args) {
		System.getenv().forEach((key, value) -> {
			System.out.println(String.format("%16s: %24s", key, value));
		});
		// -Duser.language=tr
		// -Duser.country=TR
		// java -Duser.language=tr -Duser.country=TR -jar app.jar
		System.getProperties()
		      .forEach((key, value) -> {
			System.out.println(String.format("%16s: %24s", key, value));
		});
	}
}
