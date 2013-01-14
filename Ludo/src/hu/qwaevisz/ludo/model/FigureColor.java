package hu.qwaevisz.ludo.model;

public enum FigureColor {

	BLUE('b'), RED('r'), GREEN('g'), YELLOW('y');

	private final char sign;

	private FigureColor(char sign) {
		this.sign = sign;
	}

	public char getSign() {
		return this.sign;
	}

}
