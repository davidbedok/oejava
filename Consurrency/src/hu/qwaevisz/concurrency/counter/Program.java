package hu.qwaevisz.concurrency.counter;

import hu.qwaevisz.concurrency.counter.atomic.AtomicCounter;
import hu.qwaevisz.concurrency.counter.atomic.AtomicRunnableCounter;

public class Program {

	public static void testInMainThread(){
		System.out.println("# NonThreadSafeCounter - test in main thread...");
		NonThreadSafeCounter iCounter = new NonThreadSafeCounter();
		System.out.println("Value before cycle: "+iCounter.currentValue());
		for (int i = 0; i < 10000; i++) {
			iCounter.decrement();
			iCounter.increment();
		}
		System.out.println("Value after 10000 cycle (+1-1): "+iCounter.currentValue());		
	}
	
	public static void testInDifferentThreads(){
		System.out.println("# NonThreadSafeCounter - test in different threads...");
		NonThreadSafeCounter iCounter = new NonThreadSafeCounter();
		System.out.println("Value before cycle: "+iCounter.currentValue());	
		for (int i = 0; i < 10000; i++) {
			(new Thread(new NTSRunnableCounter(iCounter, false))).start(); 
			(new Thread(new NTSRunnableCounter(iCounter, true))).start();			
		}		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}			
		System.out.println("Value after 10000 cycle (+1-1): "+iCounter.currentValue());					
	}
	
	public static void testInDifferentThreadsSynchronized(){
		System.out.println("# testInDifferentThreadsSynchronized");
		ThreadSafeCounter iCounter = new ThreadSafeCounter();
		System.out.println("Value before cycle: "+iCounter.currentValue());	
		for (int i = 0; i < 10000; i++) {
			(new Thread(new TSRunnableCounter(iCounter, false))).start(); 
			(new Thread(new TSRunnableCounter(iCounter, true))).start();			
		}		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}			
		System.out.println("Value after 10000 cycle (+1-1): "+iCounter.currentValue());					
	}	
	
	public static void testAtomic(){
		System.out.println("# testAtomic");
		AtomicCounter iCounter = new AtomicCounter();
		System.out.println("Value before cycle: "+iCounter.currentValue());	
		for (int i = 0; i < 10000; i++) {
			(new Thread(new AtomicRunnableCounter(iCounter, false))).start(); 
			(new Thread(new AtomicRunnableCounter(iCounter, true))).start();			
		}		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}			
		System.out.println("Value after 10000 cycle (+1-1): "+iCounter.currentValue());					
	}	
	
	public static void main(String argy[]) {
		// Program.testInMainThread();
		/*
		Program.testInDifferentThreads();	
		Program.testInDifferentThreadsSynchronized();
		*/
		Program.testAtomic();
	}

}
