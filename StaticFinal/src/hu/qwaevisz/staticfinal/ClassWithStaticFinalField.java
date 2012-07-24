package hu.qwaevisz.staticfinal;

public class ClassWithStaticFinalField {

	/*
	 * csak egyszer irhato (csak inicializalas soran (konstruktorban NEM))
	 * olvashato
	 * 
	 * osztaly szintu
	 *    - JVM-ben az osztaly betoltesekor egyszer kerul mem. terulete lefoglalasra
	 *    - osztalynev. alapu eleres a javasolt, de lehet this. -al is (de utobbi warning, keruluendo)
	 *    
	 * javasolt a public lathatosag 
	 * 
	 * "konstans", a const technikai nem hasznalt foglalt szo lehetne static final helyett
	 */
	public static final int STATIC_FINAL_FIELD = 42;
	
	public ClassWithStaticFinalField (){
		System.out.println("ClassWithStaticFinalField STATIC_FINAL_FIELD in constructor --> "+ClassWithStaticFinalField.STATIC_FINAL_FIELD);
		// System.out.println("ClassWithStaticFinalField STATIC_FINAL_FIELD in constructor --> "+this.STATIC_FINAL_FIELD); --> warning, kerulendo
	}
		
	public void method(){
		System.out.println("ClassWithStaticFinalField STATIC_FINAL_FIELD in method --> "+ClassWithStaticFinalField.STATIC_FINAL_FIELD);
	}
	
	public static void staticMethod(){
		System.out.println("ClassWithStaticFinalField STATIC_FINAL_FIELD in staticMethod --> "+ClassWithStaticFinalField.STATIC_FINAL_FIELD);
	}
	
}
