package hu.qwaevisz.concurrency.counter;

public class ThreadSafeCounter {
  		
	private int counter = 0;
		
	public synchronized void increment() {
		++counter;
	}
	
	public synchronized void decrement() {
		--counter;
	}

	public synchronized int currentValue() {
		return counter;
	}  

}
