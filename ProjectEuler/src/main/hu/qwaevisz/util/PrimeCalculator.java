package hu.qwaevisz.util;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {

	public boolean isPrime(long number) {
		if (number == 1) {
			return false;
		} else if (number < 4) {
			return true;
		} else if (number % 2 == 0) {
			return false;
		} else if (number < 9) {
			return true;
		} else if (number % 3 == 0) {
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
		if (startNumber < 2) {
			return 2;
		} else if (startNumber == 2) {
			return 3;
		}
		long number = (startNumber % 2 == 0 ? startNumber + 1 : startNumber + 2);
		while (!this.isPrime(number)) {
			number += 2;
		}
		return number;
	}

	public List<Integer> eratosthenesAlgorithm(int limit) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] sieve = new boolean[limit]; // szita
		sieve[0] = true;
		sieve[1] = true;
		sieve[2] = false; // prime
		double squareRootOfLimit = Math.sqrt(limit);
		for (int i = 4; i < limit; i += 2) {
			sieve[i] = true;
		}
		for (int i = 3; i < squareRootOfLimit; i += 2) {
			if (!sieve[i]) {
				// all second number are even, and its already have marked
				for (int j = i * i; j < limit; j += 2 * i) {
					sieve[j] = true;
				}
			}
		}
		for (int i = 2; i < limit; i++) {
			if (!sieve[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

}
