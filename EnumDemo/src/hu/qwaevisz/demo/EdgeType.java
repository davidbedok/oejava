package hu.qwaevisz.demo;

public enum EdgeType implements DemoEnumable {

	NORMAL("Normal arc", "NORMAL"), //
	INHIBITOR("Inhibitor arc", "INHIBITOR"), //
	RESET("Reset arc", "RESET");

	private String name;
	private String value;

	private EdgeType(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getValue() {
		return this.value;
	}

	public static EdgeType getEnumByValue(String value) {
		EdgeType ret = EdgeType.getDefault();
		for (EdgeType cs : EdgeType.values()) {
			if (cs.getValue().equals(value)) {
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
		return this.name;
	}

	@Override
	public void hello() {

	}

}