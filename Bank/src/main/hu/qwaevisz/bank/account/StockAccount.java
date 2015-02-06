package hu.qwaevisz.bank.account;

import hu.qwaevisz.bank.common.Securities;

public class StockAccount extends Account {

	private final Securities securities;

	public StockAccount(final double value, final Securities securities) {
		super(value);
		this.securities = securities;
	}

}
