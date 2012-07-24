package hu.qwaevisz.chat.client;

public enum Operation {

	NONE("none"), //
	NEWMESSAGE("newmessage"), //
	LIST("list"), //
	KILLSERVER("killserver"), //
	EXIT("exit");

	private final String value;

	private Operation(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Operation fromValue(String value) {
		Operation ret = Operation.getDefault();
		for (Operation op : Operation.values()) {
			if (op.getValue().equals(value)) {
				ret = op;
			}
		}
		return ret;
	}

	public static Operation getDefault() {
		return Operation.NONE;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
