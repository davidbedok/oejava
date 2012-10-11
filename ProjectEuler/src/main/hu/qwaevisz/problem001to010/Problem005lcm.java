package hu.qwaevisz.problem001to010;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author edvibed
 * 
 */
public class Problem005lcm {

	/**
	 * Euclidean algorithm
	 * 
	 * legnagyobb kozos oszto
	 * 
	 */
	public long greatestCommonDivisor(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return this.greatestCommonDivisor(b, a % b);
		}
	}

	/**
	 * legkisebb kozos tobbszoros
	 * 
	 */
	public long leastCommonMultiple(long a, long b) {
		return a * b / this.greatestCommonDivisor(a, b);
	}

	public long greatestCommonDivisorNonRecursion(long a, long b) {
		long tmpA = a;
		long tmpB = b;
		long tmp;
		while (tmpB != 0) {
			tmp = tmpB;
			tmpB = tmpA % tmpB;
			tmpA = tmp;
		}
		return tmpA;
	}

	public long leastCommonMultiple(long[] numbers) {
		long lcm = 0;
		if (numbers.length > 1) {
			lcm = this.leastCommonMultiple(numbers[0], numbers[1]);
			for (int i = 2; i < numbers.length; i++) {
				lcm = this.leastCommonMultiple(lcm, numbers[i]);
			}
		}
		return lcm;
	}

}
