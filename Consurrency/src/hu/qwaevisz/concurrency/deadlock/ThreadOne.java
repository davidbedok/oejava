package hu.qwaevisz.concurrency.deadlock;

public class ThreadOne extends Thread {

	private Object resource1;
    private Object resource2;
	
	public ThreadOne( Object resource1, Object resource2 ){
		System.out.println("[ThreadOne] instance created..");
		this.resource1 = resource1;
		this.resource2 = resource2;
	}
	
	public void run() { 
		System.out.println("[ThreadOne] START..");
		
		System.out.println("[ThreadOne] try to locked resource 1..");
        synchronized (resource1) {
          System.out.println("[ThreadOne] locked resource 1..");

          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
            return;
          }

          System.out.println("[ThreadOne] try to locked resource 2..");
          synchronized (resource2) {
            System.out.println("[ThreadOne] locked resource 2..");
          }
        }
        System.out.println("[ThreadOne] END..");
      }	
	
	
	
}
