package hu.qwaevisz.problem001to010;

import hu.qwaevisz.util.PrimeCalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author edvibed
 * 
 */
public class Problem003primefactors {

	private final PrimeCalculator	primeCalculator;

	public Problem003primefactors() {
		this.primeCalculator = new PrimeCalculator();
	}

	public List<Long> primeFactors(long number) {
		List<Long> primeFactors = new ArrayList<Long>();
		long numberHolder = number;
		long prime = 2;
		while (numberHolder != prime) {
			if (numberHolder % prime == 0) {
				primeFactors.add(prime);
				numberHolder = numberHolder / prime;
			} else {
				prime = this.primeCalculator.getNextPrimeNumber(prime);
			}
		}
		primeFactors.add(prime);
		return primeFactors;
	}

	public long getMaximumPrimeFactors(long number) {
		List<Long> primeFactors = this.primeFactors(number);
		return Collections.max(primeFactors);
	}

	public long getMaximumPrimeFactorsAlter(long number) {
		List<Long> primeFactors = this.primeFactors(number);
		return primeFactors.get(primeFactors.size() - 1);
	}

}
