package com.example.banking.domain;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {

	private final Money deficit;

	public InsufficientBalanceException(String message, Money deficit) {
		super(message);
		this.deficit = deficit;
	}

	public Money getDeficit() {
		return deficit;
	}

	
}
