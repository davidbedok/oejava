package hu.qwaevisz.hiking;

public class Team {

	private static final int	MAX_HIKERS	= 5;

	private final String		name;
	private final Trip			trip;
	private final boolean		success;
	private final Hiker[]		hikers;
	private int					index;

	public Team(String name, Trip trip, boolean success) {
		this.name = name;
		this.trip = trip;
		this.success = success;
		this.hikers = new Hiker[Team.MAX_HIKERS];
		this.index = 0;
	}

	public void add(Hiker hiker) {
		if (this.index < Team.MAX_HIKERS) {
			this.hikers[this.index++] = hiker;
		}
	}

	public String getName() {
		return this.name;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String tripEvent() {
		return this.trip.getEvent();
	}

	public boolean hasHiker(String name) {
		int i = 0;
		while (i < this.index && !this.hikers[i].getName().equals(name)) {
			i++;
		}
		return i < this.index;
	}

	public int point(String name) {
		int i = 0;
		while (i < this.index && !this.hikers[i].getName().equals(name)) {
			i++;
		}
		return this.trip.hardnessPoint() * this.age(this.hikers[i]);
	}

	private int age(Hiker hiker) {
		return this.trip.getYear() - hiker.getBirthYear();
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(50);
		info.append(this.name).append(" - ").append(this.trip);
		info.append(this.success ? " SUCCESSFUL " : " FAILED").append("\n");
		for (int i = 0; i < this.index; i++) {
			info.append("   > ").append(this.hikers[i]).append("\n");
		}
		return info.toString();
	}

}
