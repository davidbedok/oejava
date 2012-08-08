package hu.qwaevisz.store.common;

public enum Material {

	Oak("Oak material"), // tolgyfa
	Beech("Beech material"), // bukkfa
	Pine("Pine material"), // fenyofa
	CherryTree("CherryTree material"), // cseresznyefa
	Plastic("Plastic material"), // muanyag
	Metal("Metal material"); // fem

	private final String	label;

	private Material(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "[" + String.format("%-20s", this.label) + "]";
	}

}
