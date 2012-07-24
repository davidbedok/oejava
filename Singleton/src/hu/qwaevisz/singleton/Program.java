package hu.qwaevisz.singleton;

public class Program {

	// volatile : a variable's value will be modified by different threads
	/*
	 * The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory"; Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.
	 * 
	 * - vagyis: a valtozohoz valo hozzaferes minden esetben olyan, mintha egy synchronized block-on belul lenne
	 * 
	 * pl: http://www.javamex.com/tutorials/synchronization_volatile_typical_use.shtml
	 */

	public static void testMethodA() {
		System.out.println("testMethodA()");
		SingletonClass sc1 = SingletonClass.getInstance();
		sc1.setFieldA(42);
	}

	public static void testMethodB() {
		System.out.println("testMethodB()");
		SingletonClass sc1 = SingletonClass.getInstance();
		System.out.println(sc1.getFieldA());
	}

	public static void testThreadSafeA() {
		System.out.println("\ntestThreadSafeA()");
		SingletonThreadSafeClass ts = SingletonThreadSafeClass.getInstance();
		ts.setFieldA(420);
	}

	public static void testThreadSafeB() {
		System.out.println("testThreadSafeB()");
		SingletonThreadSafeClass ts = SingletonThreadSafeClass.getInstance();
		System.out.println(ts.getFieldA());
	}

	public static void main(String[] args) {
		Program.testMethodA();
		Program.testMethodB();

		Program.testThreadSafeA();
		Program.testThreadSafeB();
	}

}
