package hu.qwaevisz.gc;

import java.util.Random;

public class DemoClass {

	private static final int ARRAY_SIZE = 10000;

	private int[] intArray;
	private Random rand;
	private int instanceUnid;

	public DemoClass(int instanceUnid) {
		this.instanceUnid = instanceUnid;
		System.out.println("DemoClass constructor invoked. instanceUnid = " + instanceUnid);
		rand = new Random();
		intArray = new int[DemoClass.ARRAY_SIZE];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = rand.nextInt(100000);
		}
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("DemoClass finalize invoked. instanceUnid = " + instanceUnid);
		super.finalize();
	}

}
