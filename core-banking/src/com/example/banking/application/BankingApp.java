package com.example.banking.application;

import static java.util.Comparator.comparing;

import java.util.function.Consumer;
import java.util.function.Function;

import com.example.banking.domain.Account;
import com.example.banking.domain.Bank;
import com.example.banking.domain.Customer;
import com.example.banking.domain.FiatCurrency;
import com.example.banking.domain.InsufficientBalanceException;
import com.example.banking.domain.Money;

@SuppressWarnings("unused")
public class BankingApp {
	public static void main(String[] args) throws InsufficientBalanceException {
		var myBank = new Bank("my bank");
		
		var jack = myBank.addCustomer("11111111110", 
				                      "jack bauer");
		jack.addAccount(new Account("tr1", 10_000));
		jack.addAccount(new Account("tr2", 20_000));
		jack.addAccount(new Account("tr5", 30_000));
		jack.addAccount(new Account("tr4"));
		jack.addAccount(new Account("tr3", 30_000));
		jack.addAccount(new Account("tr6"));
		jack.addAccount(new Account("tr7", 70_000));
		jack.addAccount(new Account("tr8"));

		var kate = myBank.addCustomer("94727801750", 
				                      "kate austen");
		jack.addAccount(new Account("tr10", 100_000));
		jack.addAccount(new Account("tr12", 200_000));
		jack.addAccount(new Account("tr15", 300_000));
		var cus = myBank.findCustomerByIdentity("94727801750");
		if (cus.isPresent()) {
			System.out.println(cus.get());
			var cusAcc = cus.get().findAccountByIban("tr12");
			if (cusAcc.isPresent()) { // guard
				cusAcc.get().withdraw(Money.valueOf(10_000,FiatCurrency.TL));
			}
		}
		Consumer<Customer> printCustomerInfo = 
				System.out::println;
		myBank.findCustomerByIdentity("94727801750")
		      .ifPresent( // Higher-Order Function
		    	printCustomerInfo.andThen(
		    		cust -> cust.findAccountByIban("tr12")
		    		            .ifPresent(acc -> {
									try {
										acc.withdraw(Money.valueOf(10_000,FiatCurrency.TL));
									} catch (InsufficientBalanceException e) {
										e.printStackTrace();
									}
								})
		        )
		       );
		System.out.println(jack.getBalance(FiatCurrency.TL));
		System.out.println(jack.getNumberOfNotEmptyAccounts());
		jack.getAccounts().forEach(System.err::println);
		jack.getEmptyAccounts().forEach(jack::dropAccount);
		// Problem definition: Sort jack's accounts wrt account's balance in descending
		// order.
//        jack.getAccounts()
//	        .stream()
//	        .sorted( (acc1,acc2) -> acc1.getBalance() > acc2.getBalance() ? -1 : +1)
//	        .forEach(System.err::println);

		Function<Account,Money> balanceExtractor = Account::getBalance;
		jack.getAccounts().stream().parallel()
				.sorted(comparing(balanceExtractor.andThen(Money::getDoubleValue)).thenComparing(Account::getIban).reversed())
				.sequential()
				.forEach(System.err::println);

	}
}
