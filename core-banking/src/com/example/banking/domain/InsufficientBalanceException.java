package com.example.banking.domain;

public class InsufficientBalanceException extends Exception {

	private final double deficit;

	public InsufficientBalanceException(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}

	
}
