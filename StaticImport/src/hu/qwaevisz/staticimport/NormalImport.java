package hu.qwaevisz.staticimport;

// import java.lang.Math;

public class NormalImport {

	public NormalImport(){
		System.out.println("NormalImport instance created.");		
	}
	
	public double getPiSqrt(){
		return Math.sqrt(Math.PI);
		// java.lang csomagot nem kell importalni, de nem hiba.
	}
		
}
