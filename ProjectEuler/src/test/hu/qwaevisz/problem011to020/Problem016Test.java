package hu.qwaevisz.problem011to020;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem016Test {

	private Problem016 problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem016();
	}

	@Test(groups = "unit")
	public void With_BigIntegers() {
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(0), 1);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(1), 2);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(2), 4);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(3), 8);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(4), 7);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(5), 5);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(6), 10);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(7), 11);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(8), 13);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(9), 8);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(10), 7);
		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(11), 14);

		Assert.assertEquals(this.problem.sumOfDigitsInPowerOfTwoWithBigInteger(1000), 1366);
	}

}
