package hu.qwaevisz.concurrency.counter;

public class TSRunnableCounter implements Runnable {
	
	ThreadSafeCounter counter = null;
	private boolean operation;
	
	public TSRunnableCounter(ThreadSafeCounter counter, boolean operation) {	
		this.counter = counter;
		this.operation = operation;
	}
	
	public void run() { 		
		if (operation) {
			counter.increment();
		} else {
			counter.decrement();
		}		
        // System.out.println("Current value:" + counter.currentValue()); 
    } 
	    		
}