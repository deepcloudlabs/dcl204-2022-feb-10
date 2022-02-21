package com.example.banking.domain;

public enum FiatCurrency {
	TL('₺'), EUR('€'), USD('$');

	private final char symbol;

	private FiatCurrency(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

}
