package hu.qwaevisz.store.common;

public enum CsvFurnitureType {
	BED("Bed"), //
	TABLE("Table"), //
	WARDROBE("Wardrobe");

	private final String	label;

	private CsvFurnitureType(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return String.format("%-9s", this.label) + ": ";
	}

}
