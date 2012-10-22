package hu.qwaevisz.oointro;

public class Hair {

	private HairType type;
	private String color;

	public Hair(HairType type) {
		this.type = type;
	}

	public HairType getType() {
		return this.type;
	}

	public void setType(HairType type) {
		this.type = type;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return (this.color != null ? this.color + " and " : "") + this.type;
	}

}
