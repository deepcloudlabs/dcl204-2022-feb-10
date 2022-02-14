package com.example.domain;

import java.util.Objects;

public class Employee extends Object {
	private String identity;
	private String fullname;
	private double salary;
	private String iban;

	public Employee(String identity, String fullname, double salary, String iban) {
		this.identity = identity;
		this.fullname = fullname;
		this.salary = salary;
		this.iban = iban;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary + ", iban=" + iban
				+ "]";
	}

	@Override
	public int hashCode() {
		System.out.println("Employee::hasCode");
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Employee::equals");
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(identity, other.identity);
	}





}
