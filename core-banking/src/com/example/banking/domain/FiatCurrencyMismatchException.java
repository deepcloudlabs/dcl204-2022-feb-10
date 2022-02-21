package com.example.banking.domain;

@SuppressWarnings("serial")
public class FiatCurrencyMismatchException extends RuntimeException {

	public FiatCurrencyMismatchException(String message) {
		super(message);
	}

}
