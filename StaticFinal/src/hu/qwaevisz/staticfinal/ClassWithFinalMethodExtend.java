package hu.qwaevisz.staticfinal;

public class ClassWithFinalMethodExtend extends ClassWithFinalMethod {

	public ClassWithFinalMethodExtend() {
		System.out.println("ClassWithFinalMethodExtend constructor invoke.");
	}

	@Override
	public void normalMethod() {
		System.out.println("normalMethod() invoke.");
	}

	/*
	 * @Override public final void finalMethod() {
	 * System.out.println("finalMethod() invoke."); }
	 */
	// Cannot override the final method from ClassWithFinalMethod

	// final metodust nem lehet override-olni

}
