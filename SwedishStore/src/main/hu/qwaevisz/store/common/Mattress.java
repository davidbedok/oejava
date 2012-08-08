package hu.qwaevisz.store.common;

public enum Mattress {

	Normal("Normal mattress"), //
	Comfortable("Comfortable mattress"), //
	Healthy("Healthy mattress"), //
	Antiallergic("Antiallergic mattress"), //
	Exclusive("Exclusive mattress"); //

	private final String	label;

	private Mattress(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-22s", this.label) + "]";
	}

}
