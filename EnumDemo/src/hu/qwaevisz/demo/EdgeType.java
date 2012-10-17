package hu.qwaevisz.demo;

public enum EdgeType implements DemoEnumable {

	NORMAL("Normal arc", 3.5), //
	INHIBITOR("Inhibitor arc"), //
	DEMO, //
	RESET("Reset arc", 6.12);

	private static final double DEF_MAGIC_VALUE = 10;

	private final String label;
	private final double magicValue;

	private EdgeType() {
		this("");
	}

	private EdgeType(String label) {
		this(label, EdgeType.DEF_MAGIC_VALUE);
	}

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
				break;
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