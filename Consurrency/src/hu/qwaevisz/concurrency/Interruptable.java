package hu.qwaevisz.concurrency;

public class Interruptable implements Runnable {

	private static final long MAX = 300000;

	private int instanceUnid;

	public Interruptable(int instanceUnid) {
		System.out.println("Interruptable [" + instanceUnid + "] instance created..");
		this.instanceUnid = instanceUnid;
	}

	@Override
	public void run() {
		try {
			System.out.println("Interruptable [" + this.instanceUnid + "] run() start..");
			double sum = 0;
			for (long i = 0; i < Interruptable.MAX * this.instanceUnid; i++) {
				// statikus metodus, mely az aktualis szalat altatja
				Thread.sleep(1); // dobhat InterruptedException-t futasa kozben
				if (i % 100 == 0) {
					System.out.println("(" + i + ")");
				}
				// statikus metodus, mely az aktualis szal megszakitas kereset jelezni tudja
				if (Thread.interrupted()) {
					throw new InterruptedException("in cycle..");
				}
				sum += Math.cos(i);
			}
			System.out.println("Interruptable [" + this.instanceUnid + "] Result: " + sum);
			System.out.println("Interruptable [" + this.instanceUnid + "] run() end..");
		} catch (InterruptedException e) {
			// bizonyos metodusok dobhatnak ilyen kivetelt (pl. sleep()), de van ahol nekunk kell kezzel dobnunk, ha a megszakitast eszleltuk
			System.out.println("Interruptable [" + this.instanceUnid + "] InterruptedException (" + e.getLocalizedMessage() + ")");
		}
	}
}
