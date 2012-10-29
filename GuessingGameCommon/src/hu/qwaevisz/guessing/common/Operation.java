package hu.qwaevisz.guessing.common;

public enum Operation {

	NONE, //
	SERVER_WELCOME(10), //
	CLIENT_INTRODUCTION(20), //
	SERVER_STARTGAME(30), //
	CLIENT_TIP(40), //
	SERVER_ANSWER(50), //
	SERVER_EXIT(60), //
	CLIENT_KILL(70);

	private final int code;

	private Operation() {
		this.code = 0;
	}

	private Operation(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static Operation fromCode(int code) {
		Operation ret = Operation.getDefault();
		for (Operation op : Operation.values()) {
			if (op.getCode() == code) {
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
		return super.toString() + " (" + this.code + ")";
	}
}
