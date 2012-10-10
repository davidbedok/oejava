package hu.qwaevisz.problem;

import hu.qwaevisz.util.PrimeCalculator;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 */
public class Problem010prime {

	private final PrimeCalculator	primeCalc;

	public Problem010prime() {
		this.primeCalc = new PrimeCalculator();
	}

	public long sumOfPrimes(long limit) {
		long sum = 0;
		long prime = 1;
		while (prime < limit) {
			prime = this.primeCalc.getNextPrimeNumber(prime);
			System.out.println(prime);
			sum += prime;
		}
		return sum - prime;
	}

}
