package hu.qwaevisz.staticimport;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class StaticImport {

	public StaticImport(){
		System.out.println("StaticImport instance created.");		
	}
	
	public double getPiSqrt(){
		return sqrt(PI); 
	}
	
}
