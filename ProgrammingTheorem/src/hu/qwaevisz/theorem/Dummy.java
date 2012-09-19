package hu.qwaevisz.theorem;

public class Dummy {

	private int	field;

	public Dummy(int field) {
		this.field = field;
	}

	public int getField() {
		return this.field;
	}

	public void setField(int field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "field: " + this.field;
	}

}
