package com.example.banking.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {
	private final BigDecimal value;
	private final FiatCurrency currency;

	private Money(BigDecimal value, FiatCurrency currency) {
		this.value = value;
		this.currency = currency;
	}

	private Money(double value, FiatCurrency currency) {
		this.value = BigDecimal.valueOf(value);
		this.currency = currency;
	}

	public static Money valueOf(BigDecimal value, FiatCurrency currency) {
		Objects.requireNonNull(currency);
		Objects.requireNonNull(value);
		return new Money(value, currency);
	}

	public static Money valueOf(double value, FiatCurrency currency) {
		Objects.requireNonNull(currency);
		return new Money(value, currency);
	}

	public BigDecimal getValue() {
		return value;
	}

	public double getDoubleValue() {
		return value.doubleValue();
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return "Balance [value=" + value + ", currency=" + currency + "]";
	}

	public Money plus(Money amount) {
		if (this.getCurrency() != amount.getCurrency())
			throw new FiatCurrencyMismatchException("You can not deposit with different currency");
		return Money.valueOf(this.value.add(amount.value), currency);
	}

	public Money minus(Money amount) {
		if (this.getCurrency() != amount.getCurrency())
			throw new FiatCurrencyMismatchException("You can not deposit with different currency");
		return Money.valueOf(this.value.subtract(amount.value), currency);
	}

	public boolean isLessThan(double amount) {
		if (this.value.doubleValue() < amount)
			return true;
		return false;
	}

	public boolean isLessThanOrEqualTo(double amount) {
		if (this.value.doubleValue() <= amount)
			return true;
		return false;
	}

	public boolean isLessThan(Money amount) {
		return isLessThan(amount.getDoubleValue());
	}

	public boolean isGreaterThan(double amount) {
		if (this.value.doubleValue() > amount)
			return true;
		return false;
	}

	public boolean isGreaterThan(Money amount) {
		return isGreaterThan(amount.getDoubleValue());
	}

	public boolean isZero() {
		return value.equals(BigDecimal.ZERO);
	}

}
