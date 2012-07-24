package hu.qwaevisz.common;

public class QContainer {

	private int contents;
	private boolean available = false;

	public synchronized int get() {
		System.out.println("[QContainer] (get) try to get contents..");
		while (available == false) {
			System.out.println("[QContainer] (get) wait() -- no contents :-( Wait other thread to PUT contents and call notify this QContainer instance..");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("[QContainer] (get) contents available to GET (contents=" + contents + ")..");
		available = false;
		System.out.println("[QContainer] (get) notifyAll() -- wake all other thread who wait this QContainer instance..");
		this.notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		System.out.println("[QContainer] (put) try to put contents..");
		while (available == true) {
			System.out.println("[QContainer] (put) wait() -- contents is not empty, so Wait other thread to GET contents and call notify this QContainer instance..");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("[QContainer] (put) contents available to PUT (contents=" + contents + ")..");
		contents = value;
		available = true;
		System.out.println("[QContainer] (put) notifyAll() -- wake all other thread who wait this QContainer instance..");
		this.notifyAll();
	}
}
