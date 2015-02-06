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

	public ExchangeRates getInstance() {
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
