package hu.qwaevisz.staticfinal;

public class ClassWithStaticField {

	/*
	 * irhato
	 * olvashato
	 * 
	 * osztaly szintu
	 *    - JVM-ben az osztaly betoltesekor egyszer kerul mem. terulete lefoglalasra
	 *    - osztalynev. alapu eleres a javasolt, de lehet this. -al is (de utobbi warning, keruluendo)
	 *    - konstruktorban, methodusban, statikus metodusban is irhato, olvashato
	 * 
	 * biztonsagosabb, ha private lathatosagu
	 */
	public static int STATIC_FIELD = 42;
		
	public ClassWithStaticField (){
		System.out.println("ClassWithStaticField STATIC_FIELD in constructor --> "+ClassWithStaticField.STATIC_FIELD);
		ClassWithStaticField.STATIC_FIELD = 10; // can be write anywhere, anytime
		// this.STATIC_FIELD = 10; --> warning, kerulendo
	}
	
	public void method(){
		ClassWithStaticField.STATIC_FIELD = 20; // can be write anywhere, anytime
		System.out.println("ClassWithStaticField STATIC_FIELD in method --> "+ClassWithStaticField.STATIC_FIELD);
		// this.STATIC_FIELD = 20; --> warning, kerulendo
	}
	
	public static void staticMethod(){
		ClassWithStaticField.STATIC_FIELD = 30; // can be write anywhere, anytime
		System.out.println("ClassWithStaticField STATIC_FIELD in staticMethod --> "+ClassWithStaticField.STATIC_FIELD);
	}	
	
}
