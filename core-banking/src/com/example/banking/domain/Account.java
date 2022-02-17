package com.example.banking.domain;

// Entity -> Persistent, identity
public class Account extends Object {
	// members:
	// 1) attribute/state/data/field
	// information hiding
	private final String iban; // instance var.
	double balance;
	private AccountStatus status = AccountStatus.ACTIVE; // 0: ACTIVE, 1: CLOSED, 2: BLOCKED
	private static int numOfAccounts = 0; 
	// 2) methods
	// i. constructors
	public Account(final String iban) {
		this(iban, 0.0);
	}

	public Account(final String iban,final double balance) {
		this.iban = iban;
		this.balance = balance;
		this.numOfAccounts++;
	}

	// getter
	
	
	public String getIban() {
		return iban;
	}

	public static int getNumOfAccounts() {
		return numOfAccounts;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(final AccountStatus status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	// business method
	public double deposit(final double amount) {
		// validation
		if (amount <= 0.0)
			throw new IllegalArgumentException(
					"amount must be positive.");
		this.balance += amount;
		return balance;
	}

	public double withdraw(final double amount) 
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