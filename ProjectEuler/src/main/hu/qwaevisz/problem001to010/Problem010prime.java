package hu.qwaevisz.problem001to010;

import hu.qwaevisz.util.PrimeCalculator;

import java.util.List;

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

	public long sumOfPrimesWithEratosthenesAlgorithm(int limit) {
		long sum = 0;
		List<Integer> primes = this.primeCalc.eratosthenesAlgorithm(limit);
		for (Integer prime : primes) {
			sum += prime;
		}
		return sum;
	}

}
