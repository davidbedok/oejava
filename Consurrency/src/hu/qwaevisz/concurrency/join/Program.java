package hu.qwaevisz.concurrency.join;

public class Program {

	public static void main(String[] args) {
		OtherImportantThread oit = new OtherImportantThread();
		oit.start();
		JoinerThread jt = new JoinerThread(oit);
		jt.start();
	}

}
