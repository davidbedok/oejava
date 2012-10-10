package hu.qwaevisz.util;

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

}
