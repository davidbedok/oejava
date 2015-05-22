package hu.qwaevisz.demo;

public class Program {

	public static void main(final String[] args) {

		final Parent p = new Parent();

		// like C#
		final Creature result = p.normal(new Crocodile());

		final Child c = new Child();

		final Crocodile result2 = c.sample(new Animal());

		// Nothing wrong!! --> Java supports
		final Parent p2 = new Child();
		final Animal resultAnimal = p2.sample(new Animal());
		System.out.println(resultAnimal.getClass().getSimpleName()); // Crocodile!!

		final Child cc = new Child();
		// overload and not override!!!
		cc.extra(new Creature());

	}

}
