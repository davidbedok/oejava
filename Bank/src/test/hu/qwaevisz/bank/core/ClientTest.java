package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.account.MoneyAccount;
import hu.qwaevisz.bank.account.StockAccount;
import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;
import hu.qwaevisz.bank.event.AccountChangeEvent;

import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;
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

	@Test(groups = "unit", enabled = true)
	public void addNewMoneyAccountAlter() {
		final Client c = new Client("Test Cient");

		final double hufValue = 500d;
		final String accountNumber = "123-123";

		final MoneyAccount moneyAccountMock = Mockito.mock(MoneyAccount.class);
		Mockito.when(moneyAccountMock.getAccountNumber()).thenReturn(accountNumber);
		Mockito.when(moneyAccountMock.getValue()).thenReturn(hufValue);
		Mockito.when(moneyAccountMock.getCurrency()).thenReturn(Currency.HUF);

		final AccountChangeEvent event = Mockito.mock(AccountChangeEvent.class);

		final ArgumentCaptor<Boolean> argAddResult = ArgumentCaptor.forClass(Boolean.class);

		c.bindAccountChanging(event);
		c.add(moneyAccountMock);

		Assert.assertEquals(c.get(accountNumber).getValue(), hufValue);
		Assert.assertTrue(c.get(accountNumber) instanceof MoneyAccount);
		final MoneyAccount moneyAccount = (MoneyAccount) c.get(accountNumber);
		Assert.assertEquals(moneyAccount.getCurrency(), Currency.HUF);

		// Mockito.verify(event).add(Matchers.eq(accountNumber), Matchers.anyBoolean());

		Mockito.verify(event).add(Matchers.eq(accountNumber), argAddResult.capture());
		Assert.assertEquals(argAddResult.getValue(), Boolean.valueOf(true));

	}

	@Test(groups = "unit", enabled = true)
	public void addNewMoneyAccountAlter2() {
		final Client c = new Client("Test Cient");

		final String accountNumber = "123-123";

		c.add(new MoneyAccountMock());

		Assert.assertEquals(c.get(accountNumber).getValue(), 500d);
		Assert.assertTrue(c.get(accountNumber) instanceof MoneyAccount);
		final MoneyAccount moneyAccount = (MoneyAccount) c.get(accountNumber);
		Assert.assertEquals(moneyAccount.getCurrency(), Currency.HUF);
	}

	private class MoneyAccountMock extends MoneyAccount {

		public MoneyAccountMock() {
			super("", 0, Currency.EUR);
		}

		@Override
		public String getAccountNumber() {
			return "123-123";
		}

		@Override
		public Currency getCurrency() {
			return Currency.HUF;
		}

		@Override
		public double getValue() {
			return 500;
		}

	}

}
