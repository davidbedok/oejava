package hu.qwaevisz.problem011to020;

import java.math.BigInteger;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem015Test {

	private Problem015pascal	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem015pascal();
	}

	@Test(groups = "unit")
	public void Pascal_triangle() {
		this.checkTriangle(this.problem.pascalTriangle(0), 1L);
		this.checkTriangle(this.problem.pascalTriangle(1), 1L, 1L);
		this.checkTriangle(this.problem.pascalTriangle(2), 1L, 2L, 1L);
		this.checkTriangle(this.problem.pascalTriangle(3), 1L, 3L, 3L, 1L);
		this.checkTriangle(this.problem.pascalTriangle(4), 1L, 4L, 6L, 4L, 1L);
		this.checkTriangle(this.problem.pascalTriangle(5), 1L, 5L, 10L, 10L, 5L, 1L);
	}

	private void checkTriangle(List<Long> calcElements, Long... elements) {
		Assert.assertEquals(calcElements.size(), elements.length);
		for (int i = 0; i < elements.length; i++) {
			Assert.assertEquals(calcElements.get(i), elements[i]);
		}
	}

	@Test(groups = "unit")
	public void Central_element_of_the_pascal_triangle() {
		Assert.assertEquals(this.problem.centralElementOfPascalTriangle(0), 1);
		Assert.assertEquals(this.problem.centralElementOfPascalTriangle(2), 2);
		Assert.assertEquals(this.problem.centralElementOfPascalTriangle(4), 6);
		Assert.assertEquals(this.problem.centralElementOfPascalTriangle(6), 20);
	}

	@Test(groups = "unit")
	public void Bastion_Problem() {
		Assert.assertEquals(this.problem.bastionProblem(1), 2);
		Assert.assertEquals(this.problem.bastionProblem(2), 6);
		Assert.assertEquals(this.problem.bastionProblem(3), 20);
		Assert.assertEquals(this.problem.bastionProblem(20), 137846528820L);
	}

	@Test(groups = "unit")
	public void Bastion_Problem_By_Expression() {
		Assert.assertEquals(this.problem.bastionProblemByExpression(1), 2);
		Assert.assertEquals(this.problem.bastionProblemByExpression(2), 6);
		Assert.assertEquals(this.problem.bastionProblemByExpression(3), 20);
	}

	@Test(groups = "unit")
	public void Bastion_Problem_By_Expression_with_BigInteger() {
		Assert.assertEquals(this.problem.bastionProblemByExpression(new BigInteger("1")), new BigInteger("2"));
		Assert.assertEquals(this.problem.bastionProblemByExpression(new BigInteger("2")), new BigInteger("6"));
		Assert.assertEquals(this.problem.bastionProblemByExpression(new BigInteger("3")), new BigInteger("20"));
		Assert.assertEquals(this.problem.bastionProblemByExpression(new BigInteger("20")), new BigInteger("137846528820"));
	}

}
