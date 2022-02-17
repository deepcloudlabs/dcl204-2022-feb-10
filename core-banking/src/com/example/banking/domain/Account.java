package com.example.banking.domain;

// Entity -> Persistent, identity
public class Account extends Object {
	// members:
	// 1) attribute/state/data/field
	// information hiding
	private final String iban; // instance var.
	double balance;
	private AccountStatus status = AccountStatus.ACTIVE; // 0: ACTIVE, 1: CLOSED, 2: BLOCKED

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

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public double deposit(double amount) {
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException(
					"amount must be positive.");
		this.balance += amount;
		return balance;
	}

	public double withdraw(double amount) 
			throws InsufficientBalanceException {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException(
					"amount must be positive.");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceException(
				"Your balance does not cover your expenses.",
				amount-balance);
		this.balance -= amount;
		return balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}