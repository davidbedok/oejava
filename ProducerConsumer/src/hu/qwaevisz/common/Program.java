package hu.qwaevisz.common;

import hu.qwaevisz.consumer.Consumer;
import hu.qwaevisz.producer.Producer;

public class Program {

	public static void main(String[] args) {
		QContainer c = new QContainer();
		Producer p1 = new Producer(c);
		Consumer c1 = new Consumer(c);
		p1.start();
		c1.start();
	}

}
