package hu.qwaevisz.store.common;

public enum LampType {

	TableLamp("table lamp"), //
	NightLight("night light"), //
	Chandelier("chandelier");

	private final String	label;

	private LampType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-13s", this.label) + "]";
	}

}
