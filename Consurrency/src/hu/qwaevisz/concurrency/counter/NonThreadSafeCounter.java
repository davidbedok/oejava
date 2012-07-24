package hu.qwaevisz.concurrency.counter;

public class NonThreadSafeCounter {

	private int counter = 0;
	
	public void increment() {
		++counter;
	}
	
	public void decrement() {
		--counter;
	}
	
	public int currentValue() {
		return counter;
	}
}
