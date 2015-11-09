package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.account.Account;
import hu.qwaevisz.bank.account.MoneyAccount;
import hu.qwaevisz.bank.account.StockAccount;
import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;
import hu.qwaevisz.bank.event.AccountChangeEvent;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private final String name;
	private final List<Account> accounts;
	private AccountChangeEvent accountChangeEvent;

	public Client(final String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}

	public String getName() {
		return this.name;
	}

	public void add(final String accountNumber, final double value, final Currency currency) {
		this.add(new MoneyAccount(accountNumber, value, currency));
	}

	public void add(final Account account) {
		// always true
		final boolean addResult = this.accounts.add(account);
		if (this.accountChangeEvent != null) {
			this.accountChangeEvent.add(account.getAccountNumber(), addResult);
		}
	}

	public void add(final String accountNumber, final double count, final Securities securities) {
		this.add(new StockAccount(accountNumber, count, securities));
	}

	public Account get(final String accountNumber) {
		Account result = null;
		for (final Account current : this.accounts) {
			if (current.getAccountNumber().equals(accountNumber)) {
				result = current;
				break;
			}
		}
		return result;
	}

	public void bindAccountChanging(final AccountChangeEvent event) {
		this.accountChangeEvent = event;
	}

	public void unbindAccountChanging() {
		this.accountChangeEvent = null;
	}

}
