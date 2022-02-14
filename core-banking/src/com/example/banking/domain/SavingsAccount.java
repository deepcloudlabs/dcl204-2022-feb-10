package com.example.banking.domain;

public class SavingsAccount extends Account {
	private double interestRate;

	public SavingsAccount(String iban, double balance, double interestRate) {
		super(iban, (1.0 + 0.01 * interestRate) * balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + ", balance=" + balance + ", iban=" + getIban()
				+ "]";
	}
	

}
