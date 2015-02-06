package hu.qwaevisz.bank.account;

import hu.qwaevisz.bank.common.Currency;

public class MoneyAccount extends Account {

	private final Currency currency;

	public MoneyAccount(final double value, final Currency currency) {
		super(value);
		this.currency = currency;
	}

}
