package com.example.banking.domain;

public class Account extends Object {
	private final String iban;
	Money balance;
	private AccountStatus status = AccountStatus.ACTIVE; // 0: ACTIVE, 1: CLOSED, 2: BLOCKED
	private static int numOfAccounts = 0; 

	public Account(final String iban) {
		this(iban, 0.0);
	}

	public Account(final String iban,final double balance) {
		this.iban = iban;
		this.balance = Money.valueOf(balance, FiatCurrency.TL);
		numOfAccounts++;
	}
	
	public Account(final String iban,final Money balance) {
		this.iban = iban;
		this.balance = balance;
		numOfAccounts++;
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

	public Money getBalance() {
		return balance;
	}

	// business method
	public Money deposit(final Money amount) {
		if (amount.isLessThanOrEqualTo(0.0))
			throw new IllegalArgumentException("Deposit amount must be positive");
		this.balance = this.balance.plus(amount);
		return balance;
	}

	public Money withdraw(final Money amount) throws InsufficientBalanceException {
		if (amount.isLessThanOrEqualTo(0.0))
			throw new IllegalArgumentException("Withdraw amount must be positive");
		// business rule
		if (balance.isLessThan(amount))
			throw new InsufficientBalanceException(
				"Your balance does not cover your expenses.",
				amount.minus(balance));
		this.balance = this.balance.minus(amount);
		return balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}