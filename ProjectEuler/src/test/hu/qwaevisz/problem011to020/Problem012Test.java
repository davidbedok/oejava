package hu.qwaevisz.problem011to020;

import hu.qwaevisz.util.DivisorCalculator;
import hu.qwaevisz.util.PrimeCalculator;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem012Test {

	private Problem012divisors			problem;
	private PrimeCalculator		primeCalculator;
	private DivisorCalculator	divisorCalculator;
	private List<Integer>		primes;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem012divisors();
		this.primeCalculator = new PrimeCalculator();
		this.divisorCalculator = new DivisorCalculator();
		this.primes = this.primeCalculator.eratosthenesAlgorithm(10000);
	}

	@Test(groups = "unit")
	public void Triangle_numbers() {
		Assert.assertEquals(this.problem.getNextTriangleNumber(0, 1), 1);
		Assert.assertEquals(this.problem.getNextTriangleNumber(1, 2), 3);
		Assert.assertEquals(this.problem.getNextTriangleNumber(3, 3), 6);
		Assert.assertEquals(this.problem.getNextTriangleNumber(6, 4), 10);
		Assert.assertEquals(this.problem.getNextTriangleNumber(10, 5), 15);
		Assert.assertEquals(this.problem.getNextTriangleNumber(15, 6), 21);
		Assert.assertEquals(this.problem.getNextTriangleNumber(21, 7), 28);
	}

	@Test(groups = "unit")
	public void Until_500_divisors_count() {
		Assert.assertEquals(this.problem.untilDivisorCounter(6, 3, 500), 76576500);
	}

	@Test(groups = "unit")
	public void Until_500_divisors_count_with_primes() {
		Assert.assertEquals(this.problem.untilDivisorCounterWithPrimes(6, 3, 500, 100000000), 76576500);
	}

	@Test(groups = "unit")
	public void Calculate_prime_factors() {
		this.checkDivisorsCount(2, 2);
		this.checkDivisors(2, 1, 2);
		this.assertPrimeFactors(2, 2); // 1 --> 2

		this.checkDivisorsCount(3, 2);
		this.checkDivisors(3, 1, 3);
		this.assertPrimeFactors(3, 3); // 1 --> 2

		this.checkDivisorsCount(4, 3);
		this.checkDivisors(4, 1, 2, 4);
		this.assertPrimeFactors(4, 2, 2); // 2 --> 3

		this.checkDivisorsCount(5, 2);
		this.checkDivisors(5, 1, 5);
		this.assertPrimeFactors(5, 5); // 1 --> 2

		this.checkDivisorsCount(6, 4);
		this.checkDivisors(6, 1, 2, 3, 6);
		this.assertPrimeFactors(6, 2, 3); // 1, 1 --> 2 * 2 = 4

		this.checkDivisorsCount(7, 2);
		this.checkDivisors(7, 1, 7);
		this.assertPrimeFactors(7, 7); // 1 --> 2

		this.checkDivisorsCount(8, 4);
		this.checkDivisors(8, 1, 2, 4, 8);
		this.assertPrimeFactors(8, 2, 2, 2); // 3 --> 4

		this.checkDivisorsCount(9, 3);
		this.checkDivisors(9, 1, 3, 9);
		this.assertPrimeFactors(9, 3, 3); // 2 --> 3

		this.checkDivisorsCount(10, 4);
		this.checkDivisors(10, 1, 2, 5, 10);
		this.assertPrimeFactors(10, 2, 5); // 1, 1 --> 2 * 2 = 4

		this.checkDivisorsCount(11, 2);
		this.checkDivisors(11, 1, 11);
		this.assertPrimeFactors(11, 11); // 1 --> 2

		this.checkDivisorsCount(12, 6);
		this.checkDivisors(12, 1, 2, 3, 4, 6, 12);
		this.assertPrimeFactors(12, 2, 2, 3); // 2, 1 --> 3 * 2 = 6

		this.checkDivisorsCount(13, 2);
		this.checkDivisors(13, 1, 13);
		this.assertPrimeFactors(13, 13); // 1 --> 2

		this.checkDivisorsCount(14, 4);
		this.checkDivisors(14, 1, 2, 7, 14);
		this.assertPrimeFactors(14, 2, 7); // 1, 1 --> 2 * 2 = 4

		this.checkDivisorsCount(15, 4);
		this.checkDivisors(15, 1, 3, 5, 15);
		this.assertPrimeFactors(15, 3, 5); // 1, 1 --> 2 * 2 = 4

		this.checkDivisorsCount(28, 6);
		this.checkDivisors(28, 1, 2, 4, 7, 14, 28);
		this.assertPrimeFactors(28, 2, 2, 7); // 2, 1 --> 3 * 2 = 6

		this.checkDivisorsCount(100, 9);
		this.checkDivisors(100, 1, 2, 4, 5, 10, 20, 25, 50, 100);
		this.assertPrimeFactors(100, 2, 2, 5, 5); // 2, 2 --> 3 * 3 = 9

		this.checkDivisorsCount(999, 8);
		this.checkDivisors(999, 1, 3, 9, 27, 37, 111, 333, 999);
		this.assertPrimeFactors(999, 3, 3, 3, 37); // 3, 1 --> 4 * 2 = 8

		this.checkDivisorsCount(1000, 16);
		this.checkDivisors(1000, 1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000);
		this.assertPrimeFactors(1000, 2, 2, 2, 5, 5, 5); // 3, 3 --> 4 * 4 = 16
	}

	private void checkDivisorsCount(long number, int divisorsCount) {
		Assert.assertEquals(this.divisorCalculator.divisorsCount(number), divisorsCount);
	}

	private void checkDivisors(long number, long... expectedDivisors) {
		List<Long> divisors = this.divisorCalculator.divisors(number);
		// System.out.println(Arrays.toString(divisors.toArray(new Long[] {})));
		if (expectedDivisors.length != divisors.size()) {
			Assert.fail();
		} else {
			int i = 0;
			for (Long divisor : divisors) {
				Assert.assertEquals(divisor.longValue(), expectedDivisors[i]);
				i++;
			}
		}
	}

	private void assertPrimeFactors(long number, long... primeFactors) {
		List<Long> actualPrimeFactors = this.primeCalculator.primeFactorsWithEratosthenes(number, this.primes);
		// System.out.println(Arrays.toString(actualPrimeFactors.toArray(new Long[] {})));
		for (int i = 0; i < primeFactors.length; i++) {
			Assert.assertEquals(actualPrimeFactors.get(i), new Long(primeFactors[i]));
		}
	}

}
