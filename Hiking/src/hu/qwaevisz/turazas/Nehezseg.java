package hu.qwaevisz.turazas;

public enum Nehezseg {

	EGYSZERU(1), //
	KONNYU(3), //
	KOZEPES(5), //
	NEHEZ(8), //
	EXTREM(10);

	private final int pont;

	private Nehezseg(int point) {
		this.pont = point;
	}

	public int getPont() {
		return this.pont;
	}

	@Override
	public String toString() {
		return this.name() + " [" + this.pont + "]";
	}

}
