package hu.qwaevisz.problem001to010;

import hu.qwaevisz.util.PrimeCalculator;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author edvibed
 * 
 */
public class Problem007prime {

	private final PrimeCalculator	primeCalc;

	public Problem007prime() {
		this.primeCalc = new PrimeCalculator();
	}

	public long getPrimeByIndex(int index) {
		long prime = 1;
		for (int i = 0; i < index; i++) {
			prime = this.primeCalc.getNextPrimeNumber(prime);
		}
		return prime;
	}

}
