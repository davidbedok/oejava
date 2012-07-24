package hu.qwaevisz.gc;

public class Program {

	public static void main(String[] args) {
		System.out.println("# Start DEMO");
		for (int i = 0; i < 1000; i++) {
			DemoClass dc = new DemoClass(i);
		}

		System.out.println("# Start DEMO with System.gc()");
		for (int i = 1000; i < 2000; i++) {
			System.gc();
			DemoClass dc = new DemoClass(i);
		}
	}

}
