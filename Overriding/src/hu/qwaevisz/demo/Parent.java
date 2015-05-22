package hu.qwaevisz.demo;

public class Parent {

	public Animal normal(final Animal a) {
		return new Crocodile();
	}

	public Animal sample(final Animal a) {
		return a;
	}

	public Animal extra(final Animal a) {
		return a;
	}

	Animal aaaa(final Creature a) {
		return new Animal();
	}

	public Animal excep1(final Animal a) throws Exception {
		return a;
	}

	public Animal excep2(final Animal a) throws Exception {
		return a;
	}

}
