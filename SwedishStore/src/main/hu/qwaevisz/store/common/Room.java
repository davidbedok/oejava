package hu.qwaevisz.store.common;

public enum Room {

	Kitchen("Kitchen"), //
	Bathroom("Bathroom"), //
	LivingRoom("Living room"), //
	Bedroom("Bedroom"), //
	Chamber("Chamber"), // kamra
	Garage("Garage"), //
	Hall("Hall"); // eloszoba

	private final String	label;

	private Room(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-12s", this.label) + "]";
	}

}
