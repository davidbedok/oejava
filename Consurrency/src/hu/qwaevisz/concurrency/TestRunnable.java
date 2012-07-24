package hu.qwaevisz.concurrency;

// a tobbszoros orokles nem lete miatt a Runnable interface implementalasa elonyosebb a Thread osztaly leszarmaztatasanal
// kod szempontjabol a TestRunnable es a TestThread osztalyok kodja azonos!
public class TestRunnable implements Runnable {

	private static final long MAX = 3000000;

	private int instanceUnid;

	public TestRunnable(int instanceUnid) {
		System.out.println("TestRunnable [" + instanceUnid + "] instance created..");
		this.instanceUnid = instanceUnid;
	}

	@Override
	public void run() {
		System.out.println("TestRunnable [" + this.instanceUnid + "] run() start..");
		double sum = 0;
		for (long i = 0; i < TestRunnable.MAX * this.instanceUnid; i++) {
			sum += Math.cos(i);
		}
		System.out.println("TestRunnable [" + this.instanceUnid + "] Result: " + sum);
		System.out.println("TestRunnable [" + this.instanceUnid + "] run() end..");
	}
}
