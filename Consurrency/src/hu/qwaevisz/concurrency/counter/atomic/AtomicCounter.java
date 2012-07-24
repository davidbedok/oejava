package hu.qwaevisz.concurrency.counter.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

  private AtomicInteger counter = new AtomicInteger(0);

  public void increment() {
    counter.incrementAndGet();
  }

  public void decrement() {
    counter.decrementAndGet();
  }

  public int currentValue() {
    return counter.get();
  }
  
}
