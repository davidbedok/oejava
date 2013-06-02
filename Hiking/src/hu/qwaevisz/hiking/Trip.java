package hu.qwaevisz.hiking;

public class Trip {

	private final String event;
	private final int year;
	private final Hardness hardness;

	public Trip(String event, int year, Hardness hardness) {
		this.event = event;
		this.year = year;
		this.hardness = hardness;
	}

	public String getEvent() {
		return this.event;
	}

	public int getYear() {
		return this.year;
	}

	public int hardnessPoint() {
		return this.hardness.getPoint();
	}

	@Override
	public String toString() {
		return this.event + " in " + this.year + " (" + this.hardness + ")";
	}

}
