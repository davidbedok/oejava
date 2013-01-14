package hu.qwaevisz.ludo.model;

public enum Figure {

	Blue('O'), //
	Red('X'), //
	Green('@'), //
	Yellow('#');

	private final char sign;

	private Figure(char sign) {
		this.sign = sign;
	}

	public char getSign() {
		return this.sign;
	}

}
