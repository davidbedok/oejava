package hu.qwaevisz.concurrency.join;

import java.util.Random;

public class OtherImportantThread extends Thread {

	private Random rand;
	private int importantValue;

	public OtherImportantThread() {
		System.out.println("[OtherImportantThread] instance creater..");
		this.rand = new Random();
	}

	@Override
	public void run() {
		System.out.println("[OtherImportantThread] run() start..");
		this.importantValue = rand.nextInt(100);
		System.out.println("[OtherImportantThread] importantValue: " + this.importantValue);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[OtherImportantThread] run() end..");
	}

	public int getImportantValue() {
		return this.importantValue;
	}

}
