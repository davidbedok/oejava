package hu.qwaevisz.problem;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem001Test {

	private Problem001dividers	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem001dividers();
	}

	@Test(groups = "unit")
	public void Sum_of_all_the_multiples() {
		Assert.assertEquals(this.problem.sumOfAllTheMultiples(0, 10, new int[] { 3, 5 }), 23);
		Assert.assertEquals(this.problem.sumOfAllTheMultiples(0, 1000, new int[] { 3, 5 }), 233168);
	}

	@Test(groups = "unit")
	public void Sum_of_dividers() {
		Assert.assertEquals(this.problem.sumDivisibleBy(0, 10, 3), 18);
		Assert.assertEquals(this.problem.sumDivisibleBy(0, 10, 3), 18);

		int sumof3 = this.problem.sumDivisibleBy(0, 999, 3);
		int sumof5 = this.problem.sumDivisibleBy(0, 999, 5);
		int sumof15 = this.problem.sumDivisibleBy(0, 999, 15);
		Assert.assertEquals(sumof3 + sumof5 - sumof15, 233168);
	}

}
