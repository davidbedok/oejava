package hu.qwaevisz.util;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PrimeCalculatorTest {

	private PrimeCalculator	primeCalculator;

	@BeforeMethod
	public void setup() {
		this.primeCalculator = new PrimeCalculator();
	}

	@Test(groups = "unit")
	public void Number_is_prime_or_not() {
		Assert.assertTrue(this.primeCalculator.isPrime(2));
		Assert.assertTrue(this.primeCalculator.isPrime(3));
		Assert.assertTrue(this.primeCalculator.isPrime(5));
		Assert.assertTrue(this.primeCalculator.isPrime(7));
		Assert.assertTrue(this.primeCalculator.isPrime(11));
		Assert.assertTrue(this.primeCalculator.isPrime(13));

		Assert.assertFalse(this.primeCalculator.isPrime(1));
		Assert.assertFalse(this.primeCalculator.isPrime(4));
		Assert.assertFalse(this.primeCalculator.isPrime(6));
		Assert.assertFalse(this.primeCalculator.isPrime(8));
		Assert.assertFalse(this.primeCalculator.isPrime(9));
		Assert.assertFalse(this.primeCalculator.isPrime(10));
	}

	@Test(groups = "unit")
	public void Calculate_next_prime_number() {
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(2), 3);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(3), 5);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(5), 7);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(7), 11);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(11), 13);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(13), 17);
		Assert.assertEquals(this.primeCalculator.getNextPrimeNumber(17), 19);
	}

	@Test(groups = "unit")
	public void Print_all_prime_number_below_a_limit() {
		List<Integer> primes = this.primeCalculator.eratosthenesAlgorithm(10);
		Assert.assertEquals(primes.size(), 4);
		Assert.assertEquals(primes.get(0), new Integer(2));
		Assert.assertEquals(primes.get(1), new Integer(3));
		Assert.assertEquals(primes.get(2), new Integer(5));
		Assert.assertEquals(primes.get(3), new Integer(7));
	}

	@Test(groups = "unit")
	public void Calculate_prime_factors() {
		this.assertPrimeFactors(this.primeCalculator.primeFactors(19), 19);
		this.assertPrimeFactors(this.primeCalculator.primeFactors(20), 2, 2, 5);
		this.assertPrimeFactors(this.primeCalculator.primeFactors(13195), 5, 7, 13, 29);
		this.assertPrimeFactors(this.primeCalculator.primeFactors(600851475143L), 71, 839, 1471, 6857);

		List<Integer> primes = this.primeCalculator.eratosthenesAlgorithm(10000);
		this.assertPrimeFactors(this.primeCalculator.primeFactorsWithEratosthenes(19, primes), 19);
		this.assertPrimeFactors(this.primeCalculator.primeFactorsWithEratosthenes(20, primes), 2, 2, 5);
		this.assertPrimeFactors(this.primeCalculator.primeFactorsWithEratosthenes(13195, primes), 5, 7, 13, 29);
		this.assertPrimeFactors(this.primeCalculator.primeFactorsWithEratosthenes(600851475143L, primes), 71, 839, 1471, 6857);
	}

	private void assertPrimeFactors(List<Long> actualPrimeFactors, long... primeFactors) {
		for (int i = 0; i < primeFactors.length; i++) {
			Assert.assertEquals(actualPrimeFactors.get(i), new Long(primeFactors[i]));
		}
	}

}
