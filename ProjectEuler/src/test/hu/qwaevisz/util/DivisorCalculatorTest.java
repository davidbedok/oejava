package hu.qwaevisz.util;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DivisorCalculatorTest {

	private DivisorCalculator	divisorCalculator;
	private PrimeCalculator		primeCalculator;

	@BeforeMethod
	public void setup() {
		this.divisorCalculator = new DivisorCalculator();
		this.primeCalculator = new PrimeCalculator();
	}

	@Test(groups = "unit")
	public void Divisors_counting() {
		Assert.assertEquals(this.divisorCalculator.divisorsCount(1), 1);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(2), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(3), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(4), 3);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(5), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(6), 4);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(7), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(8), 4);
		Assert.assertEquals(this.divisorCalculator.divisorsCount(1000), 16);

		List<Integer> primes = this.primeCalculator.eratosthenesAlgorithm(10000);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(1, primes), 1);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(2, primes), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(3, primes), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(4, primes), 3);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(5, primes), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(6, primes), 4);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(7, primes), 2);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(8, primes), 4);
		Assert.assertEquals(this.divisorCalculator.divisorsCountWithPrimes(1000, primes), 16);
	}

	@Test(groups = "unit")
	public void List_of_Divisors() {
		this.checkDivisors(1, 1);
		this.checkDivisors(2, 1, 2);
		this.checkDivisors(3, 1, 3);
		this.checkDivisors(4, 1, 2, 4);
		this.checkDivisors(5, 1, 5);
		this.checkDivisors(6, 1, 2, 3, 6);
		this.checkDivisors(7, 1, 7);
		this.checkDivisors(8, 1, 2, 4, 8);
		this.checkDivisors(9, 1, 3, 9);
		this.checkDivisors(10, 1, 2, 5, 10);
		this.checkDivisors(11, 1, 11);
		this.checkDivisors(12, 1, 2, 3, 4, 6, 12);
		this.checkDivisors(13, 1, 13);
		this.checkDivisors(14, 1, 2, 7, 14);
		this.checkDivisors(15, 1, 3, 5, 15);
		this.checkDivisors(100, 1, 2, 4, 5, 10, 20, 25, 50, 100);
		this.checkDivisors(999, 1, 3, 9, 27, 37, 111, 333, 999);
		this.checkDivisors(1000, 1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000);
	}

	private void checkDivisors(long number, long... expectedDivisors) {
		List<Long> divisors = this.divisorCalculator.divisors(number);
		System.out.println(Arrays.toString(divisors.toArray(new Long[] {})));
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

}
