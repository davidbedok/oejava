package hu.qwaevisz.store.market;

import hu.qwaevisz.store.api.AbstractMarketGoods;
import hu.qwaevisz.store.common.LampType;
import hu.qwaevisz.store.common.SupplementaryType;

public class Lamp extends AbstractMarketGoods {

	private static final String	LUMEN	= "lm";

	private final LampType		lampType;
	private final int			flux;

	public Lamp(String fancyName, SupplementaryType supplementaryType, double price, LampType lampType, int flux) {
		super(fancyName, supplementaryType, price);
		this.lampType = lampType;
		this.flux = flux;
	}

	public LampType getLampType() {
		return this.lampType;
	}

	public int getFlux() {
		return this.flux;
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.lampType + " " + this.flux + " " + Lamp.LUMEN;
	}

}
