package hu.qwaevisz.oointro;

public class Program {

	private static void testPerson() {
		System.out.println("# testPerson");
		Person person = new Person("Nemecsek Erno", 1907);
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
	}

	public static void main(String[] args) {
		Program.testPerson();
	}

}
