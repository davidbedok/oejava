package hu.qwaevisz.demo;

public enum EdgeType implements DemoEnumable {

	NORMAL("Normal arc", 3.5), //
	INHIBITOR("Inhibitor arc", 10.2), //
	RESET("Reset arc", 6.12);

	private final String	label;
	private final double	magicValue;

	private EdgeType(String label, double magicValue) {
		this.label = label;
		this.magicValue = magicValue;
	}

	public String getLabel() {
		return this.label;
	}

	public double getMagicValue() {
		return this.magicValue;
	}

	public static EdgeType getEnumByLabel(String label) {
		EdgeType ret = EdgeType.getDefault();
		for (EdgeType cs : EdgeType.values()) {
			if (cs.getLabel().equals(label)) {
				ret = cs;
			}
		}
		return ret;
	}

	public static EdgeType getDefault() {
		return EdgeType.NORMAL;
	}

	@Override
	public String toString() {
		return this.label + " (" + this.magicValue + ") " + super.toString();
	}

	@Override
	public void hello() {
		// TODO
	}

}