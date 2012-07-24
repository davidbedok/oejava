package hu.qwaevisz.innerclass;

// Top Level Outer class
public class OuterClass {

	private int outerClassField;

	public OuterClass(int outerClassField) {
		System.out.println("OuterClass constructor (outerClassField:" + outerClassField + ").");
		this.outerClassField = outerClassField;
	}

	public void testMethod() {

		final int localFinalInt = 100;

		// - a lokalis valozokhoz hasonloan nem megengedett a lathatosag allitasa (public, protected, private)
		// - nem lehet statikus sem, hasonloan a lokalis valtozokhoz

		// Local Inner Class
		class LocalInnerClass extends java.lang.Object {

			private int innerClassField;

			public LocalInnerClass(int innerClassField) {
				this.innerClassField = innerClassField;
				System.out.println("LocalInnerClass constructor (innerClassField: " + innerClassField + ").");
				System.out.println("Reach local final variable (localFinalInt: " + localFinalInt + ")");
				System.out.println("Reach private outer class field: (outerClassField: " + outerClassField + ")");
			}

			public int getInnerClassField() {
				return innerClassField;
			}

			public void setInnerClassField(int innerClassField) {
				this.innerClassField = innerClassField;
			}

			@Override
			public String toString() {
				return "LocalInnerClass toString() --> innerClassField = " + this.innerClassField + "  outerClassField = " + outerClassField;
			}

		}

		LocalInnerClass lic1 = new LocalInnerClass(42);
		// nincs jelentosege a private lathatosagnak (blokkon belul vagyunk)!
		lic1.innerClassField = 10;
		lic1.setInnerClassField(42);
		System.out.println(lic1);

		// A lokalis inner class-okat blokkon belul barmennyiszer peldanyosithatjuk
		LocalInnerClass lic2 = new LocalInnerClass(30);
		System.out.println(lic2);

	}

}
