package hu.qwaevisz.problem001to010;

import hu.qwaevisz.problem001to010.Problem006sum;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem006Test {

	private Problem006sum	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem006sum();
	}

	@Test(groups = "unit")
	public void Sum_of_squares() {
		Assert.assertEquals(this.problem.sumOfSquares(1, 10), 385);
		Assert.assertEquals(this.problem.sumOfSquares(1, 100), 338350);
	}

	@Test(groups = "unit")
	public void Sum_of_numbers() {
		Assert.assertEquals(this.problem.sumOfNumbers(1, 5), 15);
		Assert.assertEquals(this.problem.sumOfNumbersAlter(5), 15);
	}

	@Test(groups = "unit")
	public void Square_of_sum() {
		Assert.assertEquals(this.problem.squareOfSum(1, 10), 3025);
		Assert.assertEquals(this.problem.squareOfSum(1, 100), 25502500);
	}

	@Test(groups = "unit")
	public void Difference() {
		Assert.assertEquals(this.problem.differenceSquareOfSumAndSumOfSquares(1, 10), 2640);
		Assert.assertEquals(this.problem.differenceSquareOfSumAndSumOfSquares(1, 100), 25164150);
	}

}
