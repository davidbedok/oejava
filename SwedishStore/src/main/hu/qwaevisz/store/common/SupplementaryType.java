package hu.qwaevisz.store.common;

public enum SupplementaryType {

	KitchenTool("Kitchen tool"), //
	BathTool("Bath tool"), //
	Decoration("Decoration"), //
	GardenTool("Garden tool"), //
	DeskTool("Desk tool");

	private final String	label;

	private SupplementaryType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-13s", this.label) + "]";
	}

}
