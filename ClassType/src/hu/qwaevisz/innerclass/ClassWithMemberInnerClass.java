package hu.qwaevisz.innerclass;

public class ClassWithMemberInnerClass {

	private int outerField;

	// reszletesebb leiras: Tree osztalyban
	// Member Inner Class
	public class MemberInnerClass extends java.lang.Object {

		private int innerField;

		public MemberInnerClass(int innerField) {
			this.innerField = innerField;
			System.out.println("MemberInnerClass constructor (innerField:" + innerField + ")");
			System.out.println("Reach private outer field (outerField: " + outerField + ")");
		}

		public int getInnerField() {
			return innerField;
		}

		public void setInnerField(int innerField) {
			this.innerField = innerField;
		}

		@Override
		public String toString() {
			return "MemberInnerClass toString() --> innerField = " + this.innerField + "  outerField = " + outerField;
		}
	}

	// - egyetlen osztaly, mely lehet statikus!
	// - semmilyen member inner class tulajdonsaggal nem rendelkezik --> nem eri el az outer private valtozoit, es nem is kell outer peldany a letrehozasukhoz
	// - van aki szerint csak specialis namespace.. (package)

	// Nested Top Level Class --> Static Member Inner Class
	public static class StaticMemberInnerClass extends java.lang.Object {

		private int innerField;

		public StaticMemberInnerClass(int innerField) {
			System.out.println("StaticMemberInnerClass constructor (innerField:" + innerField + ").");
		}

		public int getInnerFieldA() {
			return innerField;
		}

		public void setInnerField(int innerField) {
			this.innerField = innerField;
		}

		@Override
		public String toString() {
			return "StaticMemberInnerClass toString() --> innerField = " + this.innerField;
		}
	}

	public ClassWithMemberInnerClass(int outerField) {
		this.outerField = outerField;
		System.out.println("ClassWithMemberInnerClass constructor (outerField:" + outerField + ").");
	}

	public void testMethod() {
		MemberInnerClass mic = new MemberInnerClass(345);
		// lathatosag oszatalyon belul inner-outer classok eseten sem szamit
		mic.innerField = 300;
		System.out.println(mic);
	}

}
