package hu.qwaevisz.bank.common;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRates {

	private static ExchangeRates instance;

	private final Map<Currency, Double> rates;

	private ExchangeRates() {
		this.rates = new HashMap<Currency, Double>();
		final Currency[] currencies = Currency.values();
		for (final Currency currency : currencies) {
			this.rates.put(currency, currency.getInitialRate());
		}
	}

	public void change(final Currency currency, final double rate) {
		this.rates.put(currency, rate);
	}

	public double get(final Currency currency) {
		return this.rates.get(currency);
	}

	public static ExchangeRates getInstance() {
		if (instance == null) {
			instance = new ExchangeRates();
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
