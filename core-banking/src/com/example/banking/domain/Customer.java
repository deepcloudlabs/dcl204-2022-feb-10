package com.example.banking.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

// Entity -> Identity
public class Customer {
	private final String identityNo;
	private String fullname;
	private final Map<String, Account> accounts = new LinkedHashMap<>();

	public Customer(String identityNo, String fullname) {
		Objects.requireNonNull(identityNo);
		Objects.requireNonNull(fullname);
		this.identityNo = identityNo;
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		Objects.requireNonNull(fullname);
		this.fullname = fullname;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public Optional<Account> findAccountByIban(
			String iban){
		return Optional.ofNullable(accounts.get(iban));
	}
	
	public Collection<Account> getAccounts() {
		return List.copyOf(accounts.values());
	}

	public Collection<Account> addAccount(
			Account account){
		Objects.requireNonNull(account);
		accounts.put(account.getIban(), account);
		return getAccounts();
	}
	public Collection<Account> dropAccount(
			Account account){
		Objects.requireNonNull(account);
		return dropAccount(account.getIban());
	}
	public Collection<Account> dropAccount(
			String iban){
		Objects.requireNonNull(iban);
		accounts.remove(iban);
		return getAccounts();
	}
	public double getBalance() {
		return getAccounts()
				  .stream()
				  .mapToDouble(Account::getBalance)
				  .sum();
	}
	public long getNumberOfNotEmptyAccounts() {
		return getAccounts()
				   .stream()
				   .mapToDouble(Account::getBalance)
				   .filter( balance -> balance > 0.0)
				   .count();
	}
	public Collection<Account> getEmptyAccounts() {
		return getAccounts()
				.stream()
				.filter( acc -> acc.getBalance() == 0.0)
				.toList();
	}

	@Override
	public String toString() {
		return "Customer [identityNo=" + identityNo + ", fullname=" + fullname + "]";
	}
	
	
}
