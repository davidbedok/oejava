package hu.qwaevisz.bank.stock;

import hu.qwaevisz.bank.common.Currency;
import hu.qwaevisz.bank.common.Securities;

import java.util.ArrayList;
import java.util.List;

public class StockExchange {

	private static final int AVERAGE_STOCKITEM_ECHO_LENGTH = 50;

	private final List<StockItem> items;

	public StockExchange() {
		this.items = new ArrayList<StockItem>();
	}

	public void add(final Securities securities, final double value, final Currency currency) {
		this.items.add(new StockItem(securities, value, currency));
	}

	public StockItem get(final Securities securities) {
		int i = 0;
		final int size = this.items.size();
		while (i < size && this.items.get(i).getSecurities() != securities) {
			i++;
		}
		return i < size ? this.items.get(i) : null;
	}

	@Override
	public String toString() {
		final StringBuilder info = new StringBuilder(this.items.size() * AVERAGE_STOCKITEM_ECHO_LENGTH);
		for (final StockItem item : this.items) {
			info.append(item).append('\n');
		}
		return info.toString();
	}

}
