package hu.qwaevisz.bank.common;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExchangeRatesTest {

	@Test(groups = "unit", enabled = true)
	public void exchangeRatesWorkAsWeWant() {
		final ExchangeRates er = ExchangeRates.getInstance();

		Assert.assertEquals(er.get(Currency.HUF), 1d);
		Assert.assertEquals(er.get(Currency.EUR), Currency.EUR.getInitialRate());

		final double newUsdRate = 100;
		er.change(Currency.USD, newUsdRate);
		Assert.assertEquals(er.get(Currency.USD), newUsdRate);
	}

}
