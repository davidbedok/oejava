package hu.qwaevisz.sample;

public class Application {

	public static void main(final String[] args) {

		final Animal a = new Animal();

		final A result = a.sample(new C());

		final Cat c = new Cat();

		final C resultC = c.doIt(new B());

	}

}
