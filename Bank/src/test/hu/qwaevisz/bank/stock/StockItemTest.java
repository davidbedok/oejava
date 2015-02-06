package hu.qwaevisz.bank.stock;

import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StockItemTest {

	@Test(groups = "unit", enabled = true)
	public void changedStockItemValueBy10percent() {
		final StockItem mol = new StockItem(Securities.MOL, 10000, Currency.HUF);
		mol.change(10);
		Assert.assertEquals(mol.getValue(), 11000d);
	}

	@Test(groups = "unit", enabled = true)
	public void changedStockItemValueByMinus5percent() {
		final StockItem mol = new StockItem(Securities.MOL, 10000, Currency.HUF);
		mol.change(-5);
		Assert.assertEquals(mol.getValue(), 9500d);
	}

}
