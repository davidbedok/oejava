package hu.qwaevisz.staticfinal;

public class ClassWithFinalMethod {

	public ClassWithFinalMethod() {
		System.out.println("ClassWithFinalMethod constructor invoke.");
	}

	public void normalMethod() {
		System.out.println("normalMethod() invoke.");
	}

	public final void finalMethod() {
		System.out.println("finalMethod() invoke.");
	}

}
