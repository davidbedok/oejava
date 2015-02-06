package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.account.Account;
import hu.qwaevisz.bank.account.MoneyAccount;
import hu.qwaevisz.bank.account.StockAccount;
import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private final String name;
	private final List<Account> accounts;

	public Client(final String name) {
		this.name = name;
		this.accounts = new ArrayList<Account>();
	}

	public void add(final String accountNumber, final double value, final Currency currency) {
		this.add(new MoneyAccount(accountNumber, value, currency));
	}

	private void add(final Account account) {
		this.accounts.add(account);
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

}
