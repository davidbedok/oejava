package hu.qwaevisz.util;

import hu.qwaevisz.util.PrimeCalculator;

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

}
