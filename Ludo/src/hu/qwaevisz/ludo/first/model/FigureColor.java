package hu.qwaevisz.ludo.first.model;

public enum FigureColor {

	Blue('O'), //
	Red('X'), //
	Green('@'), //
	Yellow('#');

	private final char sign;

	private FigureColor(char sign) {
		this.sign = sign;
	}

	public char getSign() {
		return this.sign;
	}

}
