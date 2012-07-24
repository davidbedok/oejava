package hu.qwaevisz.staticimport;

public class Program {
	
	public static void main(String[] args) {
		NormalImport ni = new NormalImport();
		System.out.println(ni.getPiSqrt());

		StaticImport si = new StaticImport();
		System.out.println(si.getPiSqrt());
	}

}
