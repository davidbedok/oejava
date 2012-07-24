package hu.qwaevisz.concurrency.counter.atomic;

public class AtomicRunnableCounter implements Runnable {
	
	AtomicCounter counter = null;
	private boolean operation;
	
	public AtomicRunnableCounter(AtomicCounter counter, boolean operation) {	
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