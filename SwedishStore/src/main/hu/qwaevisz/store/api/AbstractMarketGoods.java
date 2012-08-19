package hu.qwaevisz.store.api;

import hu.qwaevisz.store.common.SupplementaryType;

public abstract class AbstractMarketGoods implements Salable {

	protected final SupplementaryType	supplementaryType;

	protected final String				fancyName;
	protected final double				price;

	public AbstractMarketGoods(String fancyName, SupplementaryType supplementaryType, double price) {
		this.fancyName = fancyName;
		this.supplementaryType = supplementaryType;
		this.price = price;
	}

	@Override
	public String getFancyName() {
		return this.fancyName;
	}

	public SupplementaryType getSupplementaryType() {
		return this.supplementaryType;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String sell(int pieces) {
		return "Item sold.";
	}

	@Override
	public String toString() {
		return this.fancyName + " " + this.supplementaryType + String.format("%3s", Math.round(this.price));
	}

}
