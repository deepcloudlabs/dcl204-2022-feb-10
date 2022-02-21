package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.FiatCurrency;
import com.example.banking.domain.InsufficientBalanceException;
import com.example.banking.domain.Money;

public class StudyPolymorphism2 {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean()) {
			acc = new Account("tr1", 10_000);
		} else {
			acc = new CheckingAccount("tr2", Money.valueOf(20_000,FiatCurrency.TL), Money.valueOf(500,FiatCurrency.TL));
		}
		System.out.println(acc.getClass().getName());
		acc.withdraw(Money.valueOf(1_000,FiatCurrency.TL));

	}

}
