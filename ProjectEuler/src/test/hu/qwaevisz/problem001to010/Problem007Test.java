package hu.qwaevisz.problem001to010;

import hu.qwaevisz.problem001to010.Problem007prime;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem007Test {

	private Problem007prime	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem007prime();
	}

	@Test(groups = "unit")
	public void Prime_by_index() {
		Assert.assertEquals(this.problem.getPrimeByIndex(1), 2);
		Assert.assertEquals(this.problem.getPrimeByIndex(2), 3);
		Assert.assertEquals(this.problem.getPrimeByIndex(3), 5);
		Assert.assertEquals(this.problem.getPrimeByIndex(4), 7);
		Assert.assertEquals(this.problem.getPrimeByIndex(5), 11);
		Assert.assertEquals(this.problem.getPrimeByIndex(6), 13);
		Assert.assertEquals(this.problem.getPrimeByIndex(10001), 104743);
	}

}
