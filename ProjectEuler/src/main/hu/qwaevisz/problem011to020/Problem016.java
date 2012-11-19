package hu.qwaevisz.problem011to020;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 */
public class Problem016 {

	public int sumOfDigitsInPowerOfTwoWithBigInteger(int powerOfTwo) {
		int sumOfDigits = 0;
		BigInteger result = new BigInteger("2").pow(powerOfTwo);
		String resultStr = result.toString();
		for (int i = 0; i < resultStr.length(); i++) {
			char currentDigit = resultStr.charAt(i);
			sumOfDigits += Integer.parseInt(String.valueOf(currentDigit));
		}
		return sumOfDigits;
	}
}
