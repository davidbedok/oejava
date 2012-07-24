package hu.qwaevisz.concurrency.join;

public class JoinerThread extends Thread {

	private OtherImportantThread importantThread;

	public JoinerThread(OtherImportantThread importantThread) {
		System.out.println("[JoinerThread] instance creater..");
		this.importantThread = importantThread;
	}

	@Override
	public void run() {
		System.out.println("[JoinerThread] run() start..");
		System.out.println("[JoinerThread] need important data from OtherImportantThread..");
		try {
			importantThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[JoinerThread] get important data :-) (" + importantThread.getImportantValue() + ")");
		System.out.println("[JoinerThread] run() end..");
	}

}
