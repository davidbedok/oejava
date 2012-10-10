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
