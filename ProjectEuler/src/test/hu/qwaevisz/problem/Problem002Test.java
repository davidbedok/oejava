package hu.qwaevisz.problem;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem002Test {

	private Problem002	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem002();
	}

	@Test(groups = "unit")
	public void Fibonacci() {
		Assert.assertEquals(this.problem.fibonacci(1), 1);
		Assert.assertEquals(this.problem.fibonacci(2), 1);
		Assert.assertEquals(this.problem.fibonacci(3), 2);
		Assert.assertEquals(this.problem.fibonacci(4), 3);
		Assert.assertEquals(this.problem.fibonacci(5), 5);
		Assert.assertEquals(this.problem.fibonacci(6), 8);
		Assert.assertEquals(this.problem.fibonacci(7), 13);
	}

	@Test(groups = "unit")
	public void Sum_of_all_fibonacci() {
		Assert.assertEquals(this.problem.sumOfAllEvenFibonacci(4000000), 4613732);
	}

	@Test(groups = "unit")
	public void Fibonacci_non_recursion() {
		Assert.assertEquals(this.problem.fibonacciNonRecursive(1), 1);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(2), 1);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(3), 2);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(4), 3);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(5), 5);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(6), 8);
		Assert.assertEquals(this.problem.fibonacciNonRecursive(7), 13);
	}

	@Test(groups = "unit")
	public void Sum_of_all_fibonacci_non_recursion() {
		Assert.assertEquals(this.problem.sumOfAllEvenFibonacciNonRecursive(4000000), 4613732);
	}

}
