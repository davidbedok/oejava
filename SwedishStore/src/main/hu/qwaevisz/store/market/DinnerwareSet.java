package hu.qwaevisz.store.market;

import hu.qwaevisz.store.api.AbstractMarketGoods;
import hu.qwaevisz.store.common.SupplementaryType;

public class DinnerwareSet extends AbstractMarketGoods {

	private final boolean	colored;

	public DinnerwareSet(String fancyName, SupplementaryType supplementaryType, double price, boolean colored) {
		super(fancyName, supplementaryType, price);
		this.colored = colored;
	}

	public boolean isColored() {
		return this.colored;
	}

	@Override
	public String toString() {
		return super.toString() + (this.colored ? "[Colored] " : "");
	}

}
