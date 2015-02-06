package hu.qwaevisz.bank.account;

import hu.qwaevisz.bank.common.Securities;

public class StockAccount extends Account {

	private final Securities securities;

	public StockAccount(final String accountNumber, final double value, final Securities securities) {
		super(accountNumber, value);
		this.securities = securities;
	}

	public Securities getSecurities() {
		return this.securities;
	}

}
