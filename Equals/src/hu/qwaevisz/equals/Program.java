package hu.qwaevisz.equals;

public class Program {

	public static void testEqualsInCar() {
		System.out.println("\n# testEqualsInCar()");
		Car c1 = new Car(2000, "Rover");
		Car c2 = new Car(2000, "Rover");

		System.out.println("c1 --> " + c1);
		System.out.println("c2 --> " + c2);
		System.out.println("c1.hashCode() --> " + c1.hashCode() + " hex: " + Integer.toHexString(c1.hashCode()));
		System.out.println("c2.hashCode() --> " + c2.hashCode() + " hex: " + Integer.toHexString(c2.hashCode()));

		System.out.println("CHECK (c1 == c2)");
		if (c1 == c2) { // false
			System.out.println("  TRUE c1 == c2");
		} else {
			System.out.println("  FALSE c1 == c2");
		}
		System.out.println("CHECK (c1.equals(c2))");
		if (c1.equals(c2)) { // false
			System.out.println("  TRUE c1.equals(c2)");
		} else {
			System.out.println("  FALSE c1.equals(c2)");
		}
	}

	public static void testEqualsInCarWithEquals() {
		System.out.println("\n# testEqualsInCarWithEquals()");
		CarWithEquals c1 = new CarWithEquals(2000, "Rover");
		CarWithEquals c2 = new CarWithEquals(2000, "Rover");

		System.out.println("c1 --> " + c1);
		System.out.println("c2 --> " + c2);
		System.out.println("c1.hashCode() --> " + c1.hashCode() + " hex: " + Integer.toHexString(c1.hashCode()));
		System.out.println("c2.hashCode() --> " + c2.hashCode() + " hex: " + Integer.toHexString(c2.hashCode()));

		System.out.println("CHECK (c1 == c2)");
		if (c1 == c2) { // false
			System.out.println("  TRUE c1 == c2");
		} else {
			System.out.println("  FALSE c1 == c2");
		}
		System.out.println("CHECK (c1.equals(c2))");
		if (c1.equals(c2)) { // true
			System.out.println("  TRUE c1.equals(c2)");
		} else {
			System.out.println("  FALSE c1.equals(c2)");
		}
		System.out.println("\n! Objects are equals, but their hashCode() are different ==> planning error --> must override hashCode() as well!");
	}

	public static void testEqualsInCarWithHashCode() {
		System.out.println("\n# testEqualsInCarWithHashCode()");
		CarWithHashCode c1 = new CarWithHashCode(2000, "Rover");
		CarWithHashCode c2 = new CarWithHashCode(2000, "Rover");

		System.out.println("c1 --> " + c1);
		System.out.println("c2 --> " + c2);
		System.out.println("c1.hashCode() --> " + c1.hashCode() + " hex: " + Integer.toHexString(c1.hashCode()));
		System.out.println("c2.hashCode() --> " + c2.hashCode() + " hex: " + Integer.toHexString(c2.hashCode()));

		System.out.println("CHECK (c1 == c2)");
		if (c1 == c2) { // false
			System.out.println("  TRUE c1 == c2");
		} else {
			System.out.println("  FALSE c1 == c2");
		}
		System.out.println("CHECK (c1.equals(c2))");
		if (c1.equals(c2)) { // true
			System.out.println("  TRUE c1.equals(c2)");
		} else {
			System.out.println("  FALSE c1.equals(c2)");
		}
		System.out
				.println("\n! OK, objects are equals, and their hashCode() are the same, but: new CarWithHashCode(2000, \"Audi\") is the same hashCode() as well.. --> must find a good hashCode() algorithm while planning..");
	}

	public static void main(String[] args) {
		Program.testEqualsInCar();
		Program.testEqualsInCarWithEquals();
		Program.testEqualsInCarWithHashCode();
	}
}
