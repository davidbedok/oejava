package hu.qwaevisz.problem;

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

	public boolean isPrime(long number) {
		if (number == 1) {
			return false;
		}
		long i = 2;
		double sqrtNumber = Math.sqrt(number);
		while ((number % i != 0) && (i <= sqrtNumber)) {
			i++;
		}
		return (i > sqrtNumber);
	}

	public long getNextPrimeNumber(long startNumber) {
		long number = (startNumber % 2 == 0 ? startNumber + 1 : startNumber + 2);
		while (!this.isPrime(number)) {
			number += 2;
		}
		return number;
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
				prime = this.getNextPrimeNumber(prime);
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
