package hu.qwaevisz.hiking;

public enum Hardness {

	LIGHT(1), //
	EASY(3), //
	MEDIUM(5), //
	HARD(8), //
	EXTREME(10);

	private final int point;

	private Hardness(int point) {
		this.point = point;
	}

	public int getPoint() {
		return this.point;
	}

	@Override
	public String toString() {
		return this.name() + " [" + this.point + "]";
	}

}
