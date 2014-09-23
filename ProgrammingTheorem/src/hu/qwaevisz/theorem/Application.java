package hu.qwaevisz.theorem;

public class Application {

	public static void main(String[] args) {
		System.out.println("Way of working");

		final People catalog = new People();
		catalog.add("Timea", EyeColor.BLUE);
		catalog.add("Julia", EyeColor.GREEN);
		catalog.add("Bela", EyeColor.BLUE);

		System.out.println(catalog);

		final Person person = catalog.getPerson(EyeColor.GREEN);
		System.out.println("Person: " + person);

	}

}
