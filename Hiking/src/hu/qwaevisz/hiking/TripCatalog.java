package hu.qwaevisz.hiking;

public class TripCatalog {

	private static final int	MAX_HIKERS	= 20;
	private static final int	MAX_TRIPS	= 5;
	private static final int	MAX_TEAMS	= 10;

	private final Trip[]		trips;
	private int					idxTrips;
	private final Hiker[]		hikers;
	private int					idxHikers;
	private final Team[]		teams;
	private int					idxTeams;

	public TripCatalog() {
		this.trips = new Trip[MAX_TRIPS];
		this.idxTrips = 0;
		this.hikers = new Hiker[MAX_HIKERS];
		this.idxHikers = 0;
		this.teams = new Team[MAX_TEAMS];
		this.idxTeams = 0;
	}

	public void registerTrip(String name, int year, Hardness hardness) {
		this.registerTrip(new Trip(name, year, hardness));
	}

	private void registerTrip(Trip trip) {
		if (this.idxTrips < MAX_TRIPS) {
			this.trips[this.idxTrips++] = trip;
		}
	}

	public void addTeam(String teamName, String tripName, boolean success) {
		Trip trip = this.findTrip(tripName);
		if (trip != null) {
			this.addTeam(new Team(teamName, trip, success));
		}
	}

	private Trip findTrip(String event) {
		Trip trip = null;
		int i = 0;
		while (i < this.idxTrips && !this.trips[i].getEvent().equals(event)) {
			i++;
		}
		if (i < this.idxTrips) {
			trip = this.trips[i];
		}
		return trip;
	}

	private void addTeam(Team team) {
		if (this.idxTeams < MAX_TEAMS) {
			this.teams[this.idxTeams++] = team;
		}
	}

	public void addHiker(String hikerName, int birthYear) {
		this.addHiker(new Hiker(hikerName, birthYear));
	}

	private void addHiker(Hiker hiker) {
		if (this.idxHikers < MAX_HIKERS) {
			this.hikers[this.idxHikers++] = hiker;
		}
	}

	public void addHikerToTeam(String teamName, String tripName, String hikerName) {
		Team team = this.findTeam(teamName, tripName);
		if (team != null) {
			Hiker hiker = this.findHiker(hikerName);
			if (hiker != null) {
				team.add(hiker);
			}
		}
	}

	private Team findTeam(String name, String tripName) {
		Team team = null;
		int i = 0;
		while (i < this.idxTeams) {
			if (this.teams[i].getName().equals(name) && this.teams[i].tripEvent().equals(tripName)) {
				team = this.teams[i];
				break;
			}
			i++;
		}
		return team;
	}

	private Hiker findHiker(String name) {
		Hiker hiker = null;
		int i = 0;
		while (i < this.idxHikers && !this.hikers[i].getName().equals(name)) {
			i++;
		}
		if (i < this.idxHikers) {
			hiker = this.hikers[i];
		}
		return hiker;
	}

	public int pointCalculation(String hikerName) {
		int point = 0;
		for (int i = 0; i < this.idxTeams; i++) {
			if (this.teams[i].hasHiker(hikerName) && this.teams[i].isSuccess()) {
				point += this.teams[i].point(hikerName);
			}
		}
		return point;
	}

	public Hiker theMostEffective() {
		Hiker mostEffective = null;
		if (this.idxHikers > 0) {
			mostEffective = this.hikers[0];
			int maxPoint = this.pointCalculation(mostEffective.getName());
			for (int i = 1; i < this.idxHikers; i++) {
				int currentPoint = this.pointCalculation(this.hikers[i].getName());
				if (currentPoint > maxPoint) {
					mostEffective = this.hikers[i];
					maxPoint = currentPoint;
				}
			}
		}
		return mostEffective;
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		info.append("# Hikers").append("\n");
		for (int i = 0; i < this.idxHikers; i++) {
			info.append(" - ").append(this.hikers[i]).append("\n");
		}
		info.append("# Trips").append("\n");
		for (int i = 0; i < this.idxTrips; i++) {
			info.append(" - ").append(this.trips[i]).append("\n");
		}
		info.append("# Teams").append("\n");
		for (int i = 0; i < this.idxTeams; i++) {
			info.append(" - ").append(this.teams[i]);
		}
		return info.toString();
	}

}
