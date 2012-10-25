package hu.qwaevisz.problem001to010;

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
