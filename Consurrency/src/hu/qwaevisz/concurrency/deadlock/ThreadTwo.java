package hu.qwaevisz.concurrency.deadlock;

public class ThreadTwo extends Thread {

	private Object resource1;
    private Object resource2;
	
	public ThreadTwo( Object resource1, Object resource2 ){
		System.out.println("[ThreadTwo] instance created..");
		this.resource1 = resource1;
		this.resource2 = resource2;
	}
	
	public void run() { 
		System.out.println("[ThreadTwo] START..");
        
		System.out.println("[ThreadTwo] try to locked resource 2..");
		synchronized (resource2) {
          System.out.println("[ThreadTwo] locked resource 2..");

          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
            return;
          }

          System.out.println("[ThreadTwo] try to locked resource 1..");
          synchronized (resource1) {
            System.out.println("[ThreadTwo] locked resource 1..");
          }
        }
        System.out.println("[ThreadTwo] END..");
      }	
	
	
	
}
