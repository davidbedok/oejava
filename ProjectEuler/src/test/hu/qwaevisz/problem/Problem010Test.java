package hu.qwaevisz.problem;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem010Test {

	private Problem010prime	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem010prime();
	}

	@Test(groups = "unit")
	public void Sum_of_primes() {
		Assert.assertEquals(this.problem.sumOfPrimes(10), 17);
		Assert.assertEquals(this.problem.sumOfPrimes(2000000), 142913828922L);
	}

}
