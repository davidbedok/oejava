package hu.qwaevisz.concurrency;

public class CanStop extends Thread {
	// Must be volatile:
	private volatile boolean stop = false;

	private int counter = 0;

	public void run() {
		while (!stop && counter < 100000) {
			System.out.println(counter++);
		}
		if (stop)
			System.out.println("Detected stop");
	}

	public void requestStop() {
		stop = true;
	}
}
