package hu.qwaevisz.problem001to010;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * @author edvibed
 * 
 */
public class Problem006sum {

	public long sumOfSquares(int start, int end) {
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i * i;
		}
		return sum;
	}

	public long squareOfSum(int start, int end) {
		long sumOfNumber = this.sumOfNumbers(start, end);
		return sumOfNumber * sumOfNumber;
	}

	public long sumOfNumbers(int start, int end) {
		return (start + end) * (end - start + 1) / 2;
	}

	public long sumOfNumbersAlter(int n) {
		return n * (n + 1) / 2;
	}

	public long differenceSquareOfSumAndSumOfSquares(int start, int end) {
		return this.squareOfSum(start, end) - this.sumOfSquares(start, end);
	}

}
