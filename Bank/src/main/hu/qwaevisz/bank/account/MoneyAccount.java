package hu.qwaevisz.bank.account;

import hu.qwaevisz.bank.common.Currency;

public class MoneyAccount extends Account {

	private final Currency currency;

	public MoneyAccount(final String accountNumber, final double value, final Currency currency) {
		super(accountNumber, value);
		this.currency = currency;
	}

	public Currency getCurrency() {
		return this.currency;
	}

}
