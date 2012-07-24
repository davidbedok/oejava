package hu.qwaevisz.common;

import hu.qwaevisz.concurrency.CanStop;
import hu.qwaevisz.concurrency.Interruptable;
import hu.qwaevisz.concurrency.TestRunnable;
import hu.qwaevisz.concurrency.TestThread;
import hu.qwaevisz.concurrency.deamon.DaemonThread;

import java.util.Timer;
import java.util.TimerTask;

public class Program {

	public static void testThread() {
		System.out.println("# testThread() - with Thread class (extends)");
		TestThread tt = new TestThread(1);
		tt.start();
		// tt.start(); // --> IllegalThreadStateException (a start() csak egyszer hivhato)

		// shorter syntax..
		(new TestThread(2)).start();
	}

	public static void testRunnable() {
		System.out.println("# testRunnable() - with Runnable interface");
		TestRunnable tr = new TestRunnable(1);
		Thread t = new Thread(tr);
		t.start();

		// shorter syntax..
		(new Thread(new TestRunnable(2))).start();
	}

	public static void testInterruptable() {
		System.out.println("# testInterruptable()");
		Interruptable tr = new Interruptable(5);
		Thread t = new Thread(tr);
		t.start();
		try {
			Thread.currentThread().sleep(3000);
			t.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void testDaemon() {
		System.out.println("# testDaemon() - BEGIN");
		DaemonThread dt = new DaemonThread(5, true); // application terminate..
		// DaemonThread dt = new DaemonThread(5, false); // application never terminate..
		dt.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("# testDaemon() - END");
	}

	public static void testCanStop() {
		final CanStop stoppable = new CanStop();
		stoppable.start();
		new Timer(true).schedule(new TimerTask() {
			public void run() {
				System.out.println("Requesting stop");
				stoppable.requestStop();
			}
		}, 300); // run() after 300 milliseconds
	}

	// http://www.java2s.com/Code/Java/Threads
	public static void main(String[] args) {
		// Program.testThread();
		// Program.testRunnable();
		// Program.testInterruptable();
		Program.testDaemon();
		// Program.testCanStop();
	}

}
