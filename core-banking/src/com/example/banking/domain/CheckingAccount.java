package com.example.banking.domain;

public class CheckingAccount extends Account {
	private Money overdraftAmount;

	public CheckingAccount(String iban, Money balance, Money overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public Money getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(Money overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public Money withdraw(Money amount) throws InsufficientBalanceException {
		System.out.println("CheckingAccount::withdraw");
		if (amount.isLessThanOrEqualTo(0.0))
			throw new IllegalArgumentException("amount must be positive.");
		if (amount.isGreaterThan(balance.plus(overdraftAmount)))
			throw new InsufficientBalanceException("Your balance does not cover your expenses.",
					amount.minus(balance).minus(overdraftAmount));
		balance = balance.minus(amount);
		return balance;
	}

}
