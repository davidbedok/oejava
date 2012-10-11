package hu.qwaevisz.problem011to020;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem012Test {

	private Problem012	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem012();
	}

	@Test(groups = "unit")
	public void Divisors_counting() {
		Assert.assertEquals(this.problem.divisorsCount(1), 1);
		Assert.assertEquals(this.problem.divisorsCount(2), 2);
		Assert.assertEquals(this.problem.divisorsCount(3), 2);
		Assert.assertEquals(this.problem.divisorsCount(4), 3);
		Assert.assertEquals(this.problem.divisorsCount(5), 2);
		Assert.assertEquals(this.problem.divisorsCount(6), 4);
		Assert.assertEquals(this.problem.divisorsCount(7), 2);
		Assert.assertEquals(this.problem.divisorsCount(8), 4);
	}

	@Test(groups = "unit")
	public void Triangle_numbers() {
		Assert.assertEquals(this.problem.getNextTriangleNumber(0, 1), 1);
		Assert.assertEquals(this.problem.getNextTriangleNumber(1, 2), 3);
		Assert.assertEquals(this.problem.getNextTriangleNumber(3, 3), 6);
		Assert.assertEquals(this.problem.getNextTriangleNumber(6, 4), 10);
		Assert.assertEquals(this.problem.getNextTriangleNumber(15, 5), 15);
		Assert.assertEquals(this.problem.getNextTriangleNumber(21, 6), 21);
		Assert.assertEquals(this.problem.getNextTriangleNumber(28, 7), 28);
	}

}
