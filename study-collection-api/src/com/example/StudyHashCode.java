package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.domain.Employee;

public class StudyHashCode {

	public static void main(String[] args) throws IOException {
		Set<Employee> employees = new HashSet<>(List.of(
				new Employee("1", "jack bauer", 100_00, "tr1"),
				new Employee("2", "kate austen", 200_00, "tr2"),
				new Employee("3", "ben linus", 300_00, "tr3"),
				new Employee("4", "james sawyer", 400_00, "tr4")
		));
		var lines = Files.readAllLines(Paths.get("src","employees.csv"));
		for (var line : lines) {
			var tokens = line.split(",");
			var employee = new Employee(tokens[0],tokens[1],Double.parseDouble(tokens[2]),tokens[3]);
			System.out.println("Read from file: "+line);
			System.out.println(employee);
			System.out.println(employees.contains(employee));
		}
	}

}
