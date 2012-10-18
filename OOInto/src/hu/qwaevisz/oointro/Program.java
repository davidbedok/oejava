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

	public static void main(String[] args) {
		Program.testPerson();
	}

}
