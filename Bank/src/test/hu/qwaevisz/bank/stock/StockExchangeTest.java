package hu.qwaevisz.bank.stock;

import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StockExchangeTest {

	@Test(groups = "unit", enabled = true)
	public void storeStockItems() {
		final StockExchange stock = new StockExchange();
		stock.add(Securities.OTP, 3500, Currency.HUF);
		stock.add(Securities.PREZI, 1500, Currency.USD);

		this.checkStockItem(stock.get(Securities.PREZI), Securities.PREZI, 1500, Currency.USD);
		this.checkStockItem(stock.get(Securities.OTP), Securities.OTP, 3500, Currency.HUF);
		Assert.assertNull(stock.get(Securities.EGIS));
		Assert.assertNull(stock.get(Securities.RICHTER));
	}

	private void checkStockItem(final StockItem item, final Securities securities, final double value, final Currency currency) {
		Assert.assertNotNull(item);
		Assert.assertEquals(item.getValue(), value);
		Assert.assertEquals(item.getSecurities(), securities);
		Assert.assertEquals(item.getCurrency(), currency);
	}

}
