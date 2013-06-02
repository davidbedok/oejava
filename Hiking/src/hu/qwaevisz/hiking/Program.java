package hu.qwaevisz.hiking;

public class Program {

	public static void main(String[] args) {
		Program.testHiker();
		Program.testTrip();
		Program.testTeam();
		Program.testTripCatalog();
	}

	private static void testHiker() {
		System.out.println("---[ Test Hiker ]---");
		Hiker hiker = new Hiker("Nemecsek Erno", 1907);
		System.out.println(hiker);
	}

	private static void testTrip() {
		System.out.println("---[ Test Trip ]---");
		Trip trip = new Trip("BHTCS", 2009, Hardness.EXTREME);
		System.out.println(trip);
	}

	private static void testTeam() {
		System.out.println("---[ Test Team ]---");
		Trip trip = new Trip("BHTCS", 2009, Hardness.EXTREME);

		Hiker hiker1 = new Hiker("Nemecsek Erno", 1907);
		Hiker hiker2 = new Hiker("Anakin Skywalker", 1981);
		Hiker hiker3 = new Hiker("MuadDib", 2005);

		Team team = new Team("IronMans", trip, true);
		team.add(hiker1);
		team.add(hiker2);
		team.add(hiker3);

		System.out.println(team);
	}

	private static void testTripCatalog() {
		System.out.println("---[ Test TripCatalog ]---");
		TripCatalog catalog = new TripCatalog();
		catalog.registerTrip("BHTCS", 2010, Hardness.HARD);
		catalog.registerTrip("Kisvasut", 2011, Hardness.LIGHT);
		catalog.registerTrip("Mecsek", 2009, Hardness.MEDIUM);

		catalog.addHiker("Hunor", 1993);
		catalog.addHiker("Csongor", 1996);
		catalog.addHiker("Zeteny", 1996);

		catalog.addTeam("Alpha", "BHTCS", true);
		catalog.addHikerToTeam("Alpha", "BHTCS", "Hunor");
		catalog.addHikerToTeam("Alpha", "BHTCS", "Csongor");

		catalog.addTeam("Beta", "BHTCS", false);
		catalog.addHikerToTeam("Beta", "BHTCS", "Zeteny");

		catalog.addTeam("Alpha", "Mecsek", false);
		catalog.addHikerToTeam("Alpha", "Mecsek", "Zeteny");
		catalog.addHikerToTeam("Alpha", "Mecsek", "Hunor");

		catalog.addTeam("Beta", "Kisvasut", true);
		catalog.addHikerToTeam("Beta", "Kisvasut", "Csongor");
		catalog.addHikerToTeam("Beta", "Kisvasut", "Zeteny");

		System.out.println(catalog);
		System.out.println("Points of Hunor: " + catalog.pointCalculation("Hunor"));
		System.out.println("Points of Csongor: " + catalog.pointCalculation("Csongor"));
		System.out.println("Points of Zeteny: " + catalog.pointCalculation("Zeteny"));

		System.out.println("The most effective Hiker: " + catalog.theMostEffective());
	}

}
