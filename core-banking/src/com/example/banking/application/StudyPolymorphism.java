package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.FiatCurrency;
import com.example.banking.domain.InsufficientBalanceException;
import com.example.banking.domain.Money;
import com.example.banking.domain.SavingsAccount;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc1 = new Account("tr1", Money.valueOf(10_000,FiatCurrency.TL));
		acc1 = new SavingsAccount("tr3", Money.valueOf(100_000,FiatCurrency.TL), 14);
		acc1 = new CheckingAccount("tr2", Money.valueOf(10_000,FiatCurrency.TL), Money.valueOf(1_000,FiatCurrency.TL));
		
		acc1.withdraw(Money.valueOf(1_000,FiatCurrency.TL)); // ???
		
		Object acc4 = new String("jack");
		acc4 = 42;
		acc4 = new int[] {4,8,15,16,23,42};
		acc4 = true;
		acc4 = new Account("tr5");
		
	}

}
