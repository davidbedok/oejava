package hu.qwaevisz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorCalculator {

	private final PrimeCalculator	primeCalculator;

	public DivisorCalculator() {
		this.primeCalculator = new PrimeCalculator();
	}

	public int divisorsCount(long number) {
		if (number == 1) {
			return 1;
		}
		if (number == 2 || number == 3) {
			return 2;
		}
		if (number == 4) {
			return 3;
		}
		int count = 2;
		double sqrtNumber = Math.sqrt(number);
		int sqrtNumberInt = (int) sqrtNumber;
		if (sqrtNumberInt * sqrtNumberInt == number) {
			count++;
		}
		if (number % 2 == 0) {
			count += 2;
			for (int i = 3; i < sqrtNumber; i++) {
				if (number % i == 0) {
					count += 2;
				}
			}
		} else {
			for (int i = 3; i < sqrtNumber; i += 2) {
				if (number % i == 0) {
					count += 2;
				}
			}
		}
		return count;
	}

	public int divisorsCountWithPrimes(long number, List<Integer> primes) {
		if (number == 1) {
			return 1;
		}
		int count = 1;
		List<Long> primeFactors = this.primeCalculator.primeFactorsWithEratosthenes(number, primes);
		long lastPrime = -1;
		List<Integer> primeExponents = new ArrayList<Integer>();
		int primeExponent = 0;
		for (Long prime : primeFactors) {
			if (lastPrime != prime) {
				lastPrime = prime;
				primeExponents.add(primeExponent + 1);
				primeExponent = 1;
			} else {
				primeExponent++;
			}
		}
		primeExponents.add(primeExponent + 1);
		for (Integer exponent : primeExponents) {
			count *= exponent;
		}
		return count;
	}

	public List<Long> divisors(long number) {
		List<Long> divisors = new ArrayList<Long>();
		divisors.add(1L);
		if (number > 1) {
			if (number == 2) {
				divisors.add(2L);
			} else if (number == 3) {
				divisors.add(3L);
			} else if (number == 4) {
				divisors.add(2L);
				divisors.add(4L);
			} else {
				divisors.add(number);
				double sqrtNumber = Math.sqrt(number);
				int sqrtNumberInt = (int) sqrtNumber;
				if (sqrtNumberInt * sqrtNumberInt == number) {
					divisors.add((long) sqrtNumberInt);
				}
				if (number % 2 == 0) {
					divisors.add(2L);
					divisors.add(number / 2);
					for (int i = 3; i < sqrtNumber; i++) {
						if (number % i == 0) {
							divisors.add((long) i);
							divisors.add(number / i);
						}
					}
				} else {
					for (int i = 3; i < sqrtNumber; i += 2) {
						if (number % i == 0) {
							divisors.add((long) i);
							divisors.add(number / i);
						}
					}
				}
			}
		}
		Collections.sort(divisors);
		return divisors;
	}
}
