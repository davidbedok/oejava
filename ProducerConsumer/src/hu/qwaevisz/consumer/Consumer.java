package hu.qwaevisz.consumer;

import hu.qwaevisz.common.QContainer;

public class Consumer extends Thread {
	private QContainer container;

	public Consumer(QContainer c) {
		System.out.println("[Consumer] instance created..");
		container = c;
	}

	public void run() {
		// folyamat celja, hogy mind a 10 arut elszallitsa amint azok elerhetoek
		int value = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println("[Consumer] TRY GET()");
			value = container.get();
			System.out.println("[Consumer] GET() RETURN: " + value);
		}
	}
}
