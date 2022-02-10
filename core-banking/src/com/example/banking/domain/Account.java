package com.example.banking.domain;

// Entity -> Persistent, identity
public class Account extends Object {
	// members:
	// 1) attribute/state/data/field
	// information hiding
	private final String iban; // instance var.
	private double balance;

	// 2) methods
	// i. constructors
	public Account(String iban) {
		this(iban, 0.0);
	}

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	// getter
	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public boolean deposit(double amount) {
		// validation
		if (amount <= 0.0)
			return false;
		this.balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		// validation
		if (amount <= 0.0)
			return false;
		// business rule
		if (amount > balance)
			return false;
		this.balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}