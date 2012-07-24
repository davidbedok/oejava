package hu.qwaevisz.staticfinal;

public class Program {

	public static void main(String[] args) {		
		System.out.println("# ClassWithStaticField");
		ClassWithStaticField cwsf = new ClassWithStaticField();
		ClassWithStaticField.STATIC_FIELD = 15;
		System.out.println("ClassWithStaticField STATIC_FIELD in main --> "+ClassWithStaticField.STATIC_FIELD);
		cwsf.method();
		// cwsf.staticMethod(); // not preref (warning)
		ClassWithStaticField.staticMethod();
	
		System.out.println("# ClassWithFinalField");
		ClassWithFinalField cwff = new ClassWithFinalField();
		System.out.println("ClassWithFinalField FINAL_FIELD in main --> "+cwff.FINAL_FIELD);
		cwff.method();
		
		System.out.println("# ClassWithStaticFinalField");
		ClassWithStaticFinalField cwsff = new ClassWithStaticFinalField();
		System.out.println("ClassWithStaticFinalField STATIC_FINAL_FIELD in main --> "+ClassWithStaticFinalField.STATIC_FINAL_FIELD);
		cwsff.method();
		// cwsff.staticMethod(); // not preref (warning)
		ClassWithStaticFinalField.staticMethod();		
	}

}
