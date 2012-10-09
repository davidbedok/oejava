package hu.qwaevisz.problem;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem003Test {

	private Problem003primefactors	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem003primefactors();
	}

	@Test(groups = "unit")
	public void Number_is_prime_or_not() {
		Assert.assertTrue(this.problem.isPrime(2));
		Assert.assertTrue(this.problem.isPrime(3));
		Assert.assertTrue(this.problem.isPrime(5));
		Assert.assertTrue(this.problem.isPrime(7));
		Assert.assertTrue(this.problem.isPrime(11));
		Assert.assertTrue(this.problem.isPrime(13));

		Assert.assertFalse(this.problem.isPrime(1));
		Assert.assertFalse(this.problem.isPrime(4));
		Assert.assertFalse(this.problem.isPrime(6));
		Assert.assertFalse(this.problem.isPrime(8));
		Assert.assertFalse(this.problem.isPrime(9));
		Assert.assertFalse(this.problem.isPrime(10));
	}

	@Test(groups = "unit")
	public void Calculate_next_prime_number() {
		Assert.assertEquals(this.problem.getNextPrimeNumber(2), 3);
		Assert.assertEquals(this.problem.getNextPrimeNumber(3), 5);
		Assert.assertEquals(this.problem.getNextPrimeNumber(5), 7);
		Assert.assertEquals(this.problem.getNextPrimeNumber(7), 11);
		Assert.assertEquals(this.problem.getNextPrimeNumber(11), 13);
		Assert.assertEquals(this.problem.getNextPrimeNumber(13), 17);
		Assert.assertEquals(this.problem.getNextPrimeNumber(17), 19);
	}

	@Test(groups = "unit")
	public void Calculate_prime_factors() {
		this.assertPrimeFactors(this.problem.primeFactors(19), new long[] { 19 });
		this.assertPrimeFactors(this.problem.primeFactors(20), new long[] { 2, 2, 5 });
		this.assertPrimeFactors(this.problem.primeFactors(13195), new long[] { 5, 7, 13, 29 });
		this.assertPrimeFactors(this.problem.primeFactors(600851475143L), new long[] { 71, 839, 1471, 6857 });
	}

	private void assertPrimeFactors(List<Long> actualPrimeFactors, long[] primeFactors) {
		for (int i = 0; i < primeFactors.length; i++) {
			Assert.assertEquals(actualPrimeFactors.get(i), new Long(primeFactors[i]));
		}
	}

	@Test(groups = "unit")
	public void Get_the_maximum_prime_factor() {
		Assert.assertEquals(this.problem.getMaximumPrimeFactors(19), 19);
		Assert.assertEquals(this.problem.getMaximumPrimeFactors(20), 5);
		Assert.assertEquals(this.problem.getMaximumPrimeFactors(13195), 29);
		Assert.assertEquals(this.problem.getMaximumPrimeFactors(600851475143L), 6857);

		Assert.assertEquals(this.problem.getMaximumPrimeFactorsAlter(19), 19);
		Assert.assertEquals(this.problem.getMaximumPrimeFactorsAlter(20), 5);
		Assert.assertEquals(this.problem.getMaximumPrimeFactorsAlter(13195), 29);
		Assert.assertEquals(this.problem.getMaximumPrimeFactorsAlter(600851475143L), 6857);
	}

}
