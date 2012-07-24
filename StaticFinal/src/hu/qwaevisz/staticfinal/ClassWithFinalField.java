package hu.qwaevisz.staticfinal;

public class ClassWithFinalField {

	/*
	 * csak egyszer irhato (inicializalas soran, vagy konstruktorban) olvashato
	 * 
	 * peldany szintu - csak this. eleres - JVM-ben minden peldany eseten mem. terulet kerul lefoglalasra szamara
	 * 
	 * megengedett a public lathatosag - peldany konstans, nincs veszely a peldany szintu irasara - kotelezo a class deklaraciojaban inicializalni (init soran,
	 * vagy konstruktor), kulonben --> error
	 */
	public final int FINAL_FIELD;
	public final int FINAL_FIELD_2 = 42; // can be write only once (in initialization)!

	// public final int FINAL_FIELD_3; // kotelezo inicializalni

	public ClassWithFinalField() {
		this.FINAL_FIELD = 30; // can be write only once (in constructor)!
		System.out.println("ClassWithFinalField FINAL_FIELD in constructor --> " + this.FINAL_FIELD);

		// this.FINAL_FIELD = 20; --> error
		// this.FINAL_FIELD_2 = 10; // --> error
	}

	public void method() {
		System.out.println("ClassWithFinalField FINAL_FIELD in method --> " + this.FINAL_FIELD);
	}

	public static void staticMethod() {
		// peldany valtozo itt nem erheto el
	}

}
