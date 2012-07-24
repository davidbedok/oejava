package hu.qwaevisz.producer;

import hu.qwaevisz.common.QContainer;

import java.util.Random;

public class Producer extends Thread {
	private QContainer container;

	public Producer(QContainer c) {
		System.out.println("[Producer] instance created..");
		container = c;
	}

	public void run() {
		final Random random = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println("[Producer] TRY PUT(" + i + ")");
			container.put(i);
			System.out.println("[Producer] PUT(" + i + ")");
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
			}
		}
	}
}
