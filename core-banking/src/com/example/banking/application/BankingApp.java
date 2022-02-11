package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;

@SuppressWarnings("unused")
public class BankingApp {
	public static void main(String[] args) {
		var jack = new Customer(
				"11111111110", "jack bauer");
		jack.addAccount(new Account("tr1",10_000));	
		jack.addAccount(new Account("tr2",20_000));	
		jack.addAccount(new Account("tr3",30_000));	
		jack.addAccount(new Account("tr4"));	
		jack.addAccount(new Account("tr5",50_000));	
		jack.addAccount(new Account("tr6"));	
		jack.addAccount(new Account("tr7",70_000));	
		jack.addAccount(new Account("tr8"));	
		System.out.println(jack.getBalance());
		System.out.println(jack.getNumberOfNotEmptyAccounts());
        jack.getAccounts().forEach(System.out::println);
        jack.getEmptyAccounts()
            .forEach(jack::dropAccount);
        jack.getAccounts().forEach(System.err::println);
	}
}
