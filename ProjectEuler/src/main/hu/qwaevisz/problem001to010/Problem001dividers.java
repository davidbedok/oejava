package hu.qwaevisz.problem001to010;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 * 
 * @author edvibed
 * 
 */
public class Problem001dividers {

	public int sumOfAllTheMultiples(int startNumber, int endNumber, int[] dividers) {
		int sum = 0;
		for (int i = startNumber; i < endNumber; i++) {
			int j = 0;
			while ((j < dividers.length) && (i % dividers[j] != 0)) {
				j++;
			}
			if (j < dividers.length) {
				sum += i;
			}
		}
		return sum;
	}

	public int sumDivisibleBy(int startNumber, int endNumber, int divider) {
		int resultOfDivisionStart = startNumber / divider;
		int resultOfDivisionEnd = endNumber / divider;
		/*
		 * 1+2+3+...+p = 1/2 * p * (p+1)
		 */
		int sumOfNumberStart = resultOfDivisionStart * (resultOfDivisionStart + 1) / 2;
		int sumOfNumberEnd = resultOfDivisionEnd * (resultOfDivisionEnd + 1) / 2;

		int sumOfNumber = sumOfNumberEnd - sumOfNumberStart;

		return divider * sumOfNumber;
	}

}
