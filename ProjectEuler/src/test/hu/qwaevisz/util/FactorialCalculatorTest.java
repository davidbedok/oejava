package hu.qwaevisz.util;

import java.math.BigInteger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

	private FactorialCalculator	factorialCalculator;

	@BeforeMethod
	public void setup() {
		this.factorialCalculator = new FactorialCalculator();
	}

	@Test(groups = "unit")
	public void Factorial_calculation() {
		Assert.assertEquals(this.factorialCalculator.factorial(0), 1L);
		Assert.assertEquals(this.factorialCalculator.factorial(1), 1L);
		Assert.assertEquals(this.factorialCalculator.factorial(2), 2L);
		Assert.assertEquals(this.factorialCalculator.factorial(3), 6L);
		Assert.assertEquals(this.factorialCalculator.factorial(4), 24L);
		Assert.assertEquals(this.factorialCalculator.factorial(5), 120L);
		Assert.assertEquals(this.factorialCalculator.factorial(6), 720L);
		Assert.assertEquals(this.factorialCalculator.factorial(7), 5040L);
		Assert.assertEquals(this.factorialCalculator.factorial(8), 40320L);
		Assert.assertEquals(this.factorialCalculator.factorial(9), 362880L);
		Assert.assertEquals(this.factorialCalculator.factorial(10), 3628800L);
	}

	@Test(groups = "unit")
	public void Factorial_calculation_with_BigInteger() {
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("0")), new BigInteger("1"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("1")), new BigInteger("1"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("2")), new BigInteger("2"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("3")), new BigInteger("6"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("4")), new BigInteger("24"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("5")), new BigInteger("120"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("6")), new BigInteger("720"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("7")), new BigInteger("5040"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("8")), new BigInteger("40320"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("9")), new BigInteger("362880"));
		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("10")), new BigInteger("3628800"));

		Assert.assertEquals(this.factorialCalculator.factorial(new BigInteger("20")), new BigInteger("2432902008176640000"));
	}

}
