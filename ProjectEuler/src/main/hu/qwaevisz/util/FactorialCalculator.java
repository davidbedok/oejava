package hu.qwaevisz.util;

import java.math.BigInteger;

public class FactorialCalculator {

	public long factorial(int number) {
		if (number == 0) {
			return 1L;
		} else if (number == 1) {
			return 1L;
		} else {
			return number * this.factorial(number - 1);
		}
	}

	public BigInteger factorial(BigInteger number) {
		if (number.equals(new BigInteger("0"))) {
			return new BigInteger("1");
		} else if (number.equals(new BigInteger("1"))) {
			return new BigInteger("1");
		} else {
			return number.multiply(this.factorial(number.add(new BigInteger("-1"))));
		}
	}

}
