package com.example.banking.application;

import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.InsufficientBalanceException;

public class StudyPolymorphism2 {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean()) {
			acc = new Account("tr1", 10_000);
		} else {
			acc = new CheckingAccount("tr2", 20_000, 500);
		}
		System.out.println(acc.getClass().getName());
		acc.withdraw(1_000);

	}

}
