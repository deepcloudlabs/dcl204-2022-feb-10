package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.InsufficientBalanceException;
import com.example.banking.domain.SavingsAccount;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc1 = new Account("tr1", 10_000);
		acc1 = new SavingsAccount("tr3", 100_000, 14);
		acc1 = new CheckingAccount("tr2", 10_000, 1_000);
		
		acc1.withdraw(1_000); // ???
		
		Object acc4 = new String("jack");
		acc4 = 42;
		acc4 = new int[] {4,8,15,16,23,42};
		acc4 = true;
		acc4 = new Account("tr5");
		
	}

}
