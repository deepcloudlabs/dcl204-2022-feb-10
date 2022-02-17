package com.example.banking.domain;

public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance,
			double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public double withdraw(double amount) 
			throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");
		if (amount <= 0) 
			throw new IllegalArgumentException(
					"amount must be positive.");
		if (amount > balance + overdraftAmount)
			throw new InsufficientBalanceException(
					"Your balance does not cover your expenses.",
					amount-balance-overdraftAmount);
		balance = balance - amount;
		return balance;
	}
	
}
