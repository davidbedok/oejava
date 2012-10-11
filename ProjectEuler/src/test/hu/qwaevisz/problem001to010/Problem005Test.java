package hu.qwaevisz.problem001to010;

import hu.qwaevisz.problem001to010.Problem005lcm;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem005Test {

	private Problem005lcm	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem005lcm();
	}

	@Test(groups = "unit")
	public void Least_Common_Multiple() {
		Assert.assertEquals(this.problem.leastCommonMultiple(6, 9), 18);
	}

	@Test(groups = "unit")
	public void Greatest_Common_Divisor() {
		Assert.assertEquals(this.problem.greatestCommonDivisor(6, 9), 3);
		Assert.assertEquals(this.problem.greatestCommonDivisorNonRecursion(6, 9), 3);
	}

	@Test(groups = "unit")
	public void Least_Common_Multiple_with_numbers() {
		Assert.assertEquals(this.problem.leastCommonMultiple(new long[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }), 2520);
		Assert.assertEquals(this.problem.leastCommonMultiple(new long[] { 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 }), 232792560);
	}

}
