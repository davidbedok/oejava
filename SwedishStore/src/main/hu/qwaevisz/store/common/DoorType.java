package hu.qwaevisz.store.common;

public enum DoorType {

	Double("Double door"), // ketszarnyu
	Sliding("Sliding door"), // tolo
	Shutter("Shutter door"); // redony

	private final String	label;

	private DoorType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-13s", this.label) + "]";
	}

}
