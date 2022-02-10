package com.example.banking.application;

import com.example.banking.domain.Account;

@SuppressWarnings("unused")
public class BankingApp {
	public static void main(String[] args) {
		Account acc = new Account("tr1", 10_000); // Local + Reference Variable	
		acc.deposit(10_000);
		acc.withdraw(17_000);
		System.out.println(acc.toString());
		System.out.println(acc.getBalance());
		int x = 42; // Local + Value-Typed
	}
}
