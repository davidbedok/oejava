package hu.qwaevisz.bank.common;

public enum Currency {

	HUF(1), //
	EUR(308), //
	CHF(290), //
	USD(270), //
	AUS(105);

	private final double initialRate;

	private Currency(final double initialRate) {
		this.initialRate = initialRate;
	}

	public double getInitialRate() {
		return this.initialRate;
	}

}
