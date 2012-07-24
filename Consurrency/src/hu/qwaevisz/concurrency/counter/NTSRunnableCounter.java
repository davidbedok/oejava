package hu.qwaevisz.concurrency.counter;

public class NTSRunnableCounter implements Runnable {
	
	NonThreadSafeCounter counter = null;
	private boolean operation;
	
	public NTSRunnableCounter(NonThreadSafeCounter counter, boolean operation) {	
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