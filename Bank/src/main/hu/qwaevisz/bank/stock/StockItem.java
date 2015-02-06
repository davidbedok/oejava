package hu.qwaevisz.bank.stock;

import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

public class StockItem {

	private final Securities securities;
	private final Currency currency;
	private double value;

	public StockItem(final Securities securities, final double value, final Currency currency) {
		this.securities = securities;
		this.currency = currency;
		this.value = value;
	}

	public Securities getSecurities() {
		return this.securities;
	}

	public double getValue() {
		return this.value;
	}

	public void change(final double percent) {
		this.value += percent / 100 * this.value;
	}

	public Currency getCurrency() {
		return this.currency;
	}

	@Override
	public String toString() {
		return this.securities + " - current value: " + this.value + " " + this.currency;
	}

}
