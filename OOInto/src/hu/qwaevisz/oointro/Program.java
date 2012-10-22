package hu.qwaevisz.oointro;

public class Program {

	private static void testPerson() {
		System.out.println("# testPerson");

		System.out.println("People counter: " + Person.getPeopleCounter());

		Person person = new Person("Nemecsek Erno", 1907, HairType.CURLY);
		person.setNickName("nemerno");
		person.setHeight(171);
		person.setWeight(65);
		String nick = person.getNickName();
		System.out.println(nick + "'s height: " + person.getHeight() + " cm");
		System.out.println(nick + "'s weight: " + person.getWeight() + " kg");
		System.out.println(nick + "'s height: " + person.getHeightInInches()
				+ " inches");
		System.out.println(person.getBirthName() + " was born in "
				+ person.getBirthYear() + ".");
		System.out.println("Length of nick: " + person.lengthOfNick());
		System.out.println("Age: " + person.age());
		System.out.println("People counter: " + Person.getPeopleCounter());

		person.getHair().setColor("brown");
		System.out.println("Hair: " + person.getHair().getColor() + " and "
				+ person.getHair().getType());

		System.out.println("Hair: " + person.getHair().toString());

	}

	private static void testPersonSimple() {
		System.out.println("# testPersonSimple");

		Person person = new Person("Nemecsek Erno", 1907, HairType.CURLY);
		person.setNickName("nemerno");
		person.setHeight(171);
		person.setWeight(65);
		person.getHair().setColor("brown");

		System.out.println(person);

	}

	private static void testPeopleCatalog() {
		System.out.println("# testPeopleCatalog");
		PeopleCatalog catalog = new PeopleCatalog();
		catalog.addPerson("Teszt Elek", 1990, HairType.STRAIGHT);
		catalog.addPerson("Darth Vader", 1981, HairType.BALD);
		catalog.addPerson("Mezga Geza", 1967, HairType.CURLY);
		catalog.addPerson("Sebaj Tobias", 1994, HairType.CURLY);
		catalog.addPerson("Nemecsek Erno", 1907, HairType.CURLY);
		catalog.addPerson("Piszkos Fred", 1949, HairType.STRAIGHT);

		System.out.println(catalog);
	}

	private static PeopleCatalog createPeopleCatalog() {
		PeopleCatalog catalog = new PeopleCatalog();
		catalog.addPerson("Teszt Elek", 1990, HairType.STRAIGHT);
		catalog.addPerson("Darth Vader", 1981, HairType.BALD);
		catalog.addPerson("Mezga Geza", 1967, HairType.CURLY);
		catalog.addPerson("Sebaj Tobias", 1994, HairType.CURLY);
		catalog.addPerson("Nemecsek Erno", 1907, HairType.CURLY);
		catalog.addPerson("Piszkos Fred", 1949, HairType.STRAIGHT);
		return catalog;
	}

	private static void testFindPerson() {
		PeopleCatalog catalog = Program.createPeopleCatalog();
		int darthVaderAge = catalog.find("Darth Vader").age();
		System.out.println("Darth Vader age: " + darthVaderAge);

		Person sebajTobias = catalog.find("Sebaj Tobias");
		if (sebajTobias != null) {
			sebajTobias.setHeight(123);
			sebajTobias.setWeight(35);
			sebajTobias.getHair().setColor("yellow");
		}
		System.out.println(catalog);
	}

	private static void testAverageAge() {
		PeopleCatalog catalog = Program.createPeopleCatalog();
		System.out.println("average age: " + catalog.averageAge());
	}

	public static void main(String[] args) {
		Program.testPerson();
		Program.testPersonSimple();
		Program.testPeopleCatalog();
		Program.testFindPerson();
		Program.testAverageAge();
	}

}
