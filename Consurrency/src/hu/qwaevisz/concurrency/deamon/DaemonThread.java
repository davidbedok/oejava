package hu.qwaevisz.concurrency.deamon;

public class DaemonThread extends Thread {

	private static final long MAX = 3000000;

	private int instanceUnid;

	public DaemonThread(int instanceUnid, boolean isDaemon) {
		System.out.println("DaemonThread [" + instanceUnid + "] instance created..");
		this.instanceUnid = instanceUnid;
		this.setDaemon(isDaemon);
	}

	@Override
	public void run() {
		try {
			System.out.println("DaemonThread [" + this.instanceUnid + "] run() start..");
			while (true) {
				System.out.print(".");
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
