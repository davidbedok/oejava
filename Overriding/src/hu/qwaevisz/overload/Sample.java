package hu.qwaevisz.overload;

public class Sample {

	public static void demo(final int i) {
		System.out.println("int " + i);
	}

	public static void demo(final long l) {
		System.out.println("long");
	}

	public static void demo(final Integer i) {
		System.out.println("Integer");
	}

	public static void demo(final Long i) {
		System.out.println("Long");
	}

	public static void demo(final Number n) {
		System.out.println("Number");
	}

	public static void demo(final double d) {
		System.out.println("double");
	}

	public static void demo(final float f) {
		System.out.println("float");
	}

	public static void main(final String[] args) {
		demo(5 / 2);
		demo(5 / 2.);
		final int maxIntValue = Integer.MAX_VALUE;
		demo(maxIntValue + 1);
	}

	public native int fewfe();

}
