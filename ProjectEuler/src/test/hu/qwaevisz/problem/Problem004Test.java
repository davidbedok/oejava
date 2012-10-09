package hu.qwaevisz.problem;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem004Test {

	private Problem004palidrom	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem004palidrom();
	}

	@Test(groups = "unit")
	public void Palidrom() {
		Assert.assertTrue(this.problem.isPalidromNumber(123321));
		Assert.assertTrue(this.problem.isPalidromNumber(9009));
		Assert.assertTrue(this.problem.isPalidromNumber(9976799));
		Assert.assertTrue(this.problem.isPalidromNumber(1));
		Assert.assertTrue(this.problem.isPalidromNumber(121));
		Assert.assertTrue(this.problem.isPalidromNumber(55666655));
	}

	@Test(groups = "unit")
	public void Find_the_maximum_product_palidrom() {
		Assert.assertEquals(this.problem.getMaximumPalidroms(100, 100), 9009);
		Assert.assertEquals(this.problem.getMaximumPalidroms(1000, 1000), 906609);
	}

}
