package hu.qwaevisz.concurrency.deadlock;

public class Program {

	public static void testDeadLock() {
		System.out.println("# testDeadLock()");
		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		ThreadOne tOne = new ThreadOne(resource1, resource2);
		ThreadTwo tTwo = new ThreadTwo(resource1, resource2);

		tOne.start();
		tTwo.start();
	}

	public static void testDeadLockMod() {
		System.out.println("# testDeadLockMod() - sort resource lock");
		final Object resource1 = "resource1";
		final Object resource2 = "resource2";

		ThreadOne tOne = new ThreadOne(resource1, resource2);
		ThreadTwoMod tTwo = new ThreadTwoMod(resource1, resource2);

		tOne.start();
		tTwo.start();
	}

	public static void main(String[] args) {
		Program.testDeadLock();
		// Program.testDeadLockMod();
	}

}
