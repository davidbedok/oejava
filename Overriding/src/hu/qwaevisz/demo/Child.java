package hu.qwaevisz.demo;

public class Child extends Parent {

	// like C#
	@Override
	public Animal normal(final Animal a) {
		return new Crocodile();
	}

	// do not use it in C#
	@Override
	public Crocodile sample(final Animal a) {
		return new Crocodile();
	}

	// not override!!
	public Animal extra(final Creature a) {
		return new Animal();
	}

	@Override
	public Animal aaaa(final Creature a) {
		return super.aaaa(a);
	}

	@Override
	public Animal excep1(final Animal a) {
		return new Animal();
	}

	@Override
	public Animal excep2(final Animal a) throws NullPointerException {
		return new Animal();
	}

}
