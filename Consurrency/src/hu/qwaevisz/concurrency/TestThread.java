package hu.qwaevisz.concurrency;

public class TestThread extends Thread {

	private static final long MAX = 3000000;

	private int instanceUnid;

	public TestThread(int instanceUnid) {
		System.out.println("TestThread [" + instanceUnid + "] instance created..");
		this.instanceUnid = instanceUnid;
	}

	@Override
	public void run() {
		System.out.println("TestThread [" + this.instanceUnid + "] run() start..");
		double sum = 0;
		for (long i = 0; i < TestThread.MAX * this.instanceUnid; i++) {
			sum += Math.cos(i);
		}
		System.out.println("TestThread [" + this.instanceUnid + "] Result: " + sum);
		System.out.println("TestThread [" + this.instanceUnid + "] run() end..");
	}

}
