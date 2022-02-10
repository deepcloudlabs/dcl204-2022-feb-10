package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AccountTest {

	@ParameterizedTest
	@CsvFileSource(resources = "accounts.csv")
	@DisplayName("Creating an account successfuly")
	void creatingAnAccountShouldSuccess(String iban, double balance) {
		// test fixture/setup
		// call exercise method: constructor
		var acc = new Account(iban, balance);
		// verification
		assertEquals(iban, acc.getIban());
		assertEquals(balance, acc.getBalance());
		// test tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "deposit-negative.csv")
	@DisplayName("Deposit with negative amount should fail")
	void depositWithNegativeAmountShouldFail(String iban, double balance, double amount) {
		// test fixture/setup
		var acc = new Account(iban, balance);
		// call exercise method -> mut
		var result = acc.deposit(amount);
		// verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
		// test tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "deposit-success.csv")
	@DisplayName("Deposit with positive amount should success")
	void depositWithPoisitiveAmountShouldSuccess(String iban, double balance, double amount, double newBalance) {
		// test fixture/setup
		var acc = new Account(iban, balance);
		// call exercise method
		var result = acc.deposit(amount);
		// verification
		assertTrue(result);
		assertEquals(newBalance, acc.getBalance());
		// test tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "withdraw-negative.csv")
	@DisplayName("Withdraw with negative amount should fail")
	void withWithNegativeAmountShouldFail(String iban, double balance, double amount) {
		// test fixture/setup
		var acc = new Account(iban, balance);
		// call exercise method -> mut
		var result = acc.deposit(amount);
		// verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
		// test tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "withdraw-success.csv")
	@DisplayName("Withdraw Under Balance should success")
	void withdrawUnderBalanceShouldSuccess(String iban, double balance, double amount, double newBalance) {
		// test fixture/setup
		var acc = new Account(iban, balance);
		// call exercise method
		var result = acc.withdraw(amount);
		// verification
		assertTrue(result);
		assertEquals(newBalance, acc.getBalance());
		// test tear-down
	}

	@ParameterizedTest
	@CsvFileSource(resources = "withdraw-over-balance.csv")
	@DisplayName("Withdraw Under Balance should success")
	void withdrawOverBalanceShouldFail(String iban, double balance, double amount) {
		// test fixture/setup
		var acc = new Account(iban, balance);
		// call exercise method
		var result = acc.withdraw(amount);
		// verification
		assertFalse(result);
		assertEquals(balance, acc.getBalance());
		// test tear-down
	}

}
