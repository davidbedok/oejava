package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.account.MoneyAccount;
import hu.qwaevisz.bank.account.StockAccount;
import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientTest {

	@Test(groups = "unit", enabled = true)
	public void addNewMoneyAccount() {
		final Client c = new Client("Test Client");
		final double hufValue = 500d;
		final String accountNumber = "123-123";
		c.add(accountNumber, hufValue, Currency.HUF);
		Assert.assertEquals(c.get(accountNumber).getValue(), hufValue);
		Assert.assertEquals(c.get(accountNumber).getClass(), MoneyAccount.class);
		Assert.assertTrue(c.get(accountNumber) instanceof MoneyAccount);
		final MoneyAccount moneyAccount = (MoneyAccount) c.get(accountNumber);
		Assert.assertEquals(moneyAccount.getCurrency(), Currency.HUF);
	}

	@Test(groups = "unit", enabled = true)
	public void addNewStockAccount() {
		final Client c = new Client("Test Client");
		final double count = 100d;
		final String accountNumber = "123-123";
		c.add(accountNumber, count, Securities.MOL);
		Assert.assertEquals(c.get(accountNumber).getValue(), count);
		Assert.assertEquals(c.get(accountNumber).getClass(), StockAccount.class);
		Assert.assertTrue(c.get(accountNumber) instanceof StockAccount);
		final StockAccount stockAccount = (StockAccount) c.get(accountNumber);
		Assert.assertEquals(stockAccount.getSecurities(), Securities.MOL);
	}

}
