package hu.qwaevisz.problem;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem008Test {

	private Problem008window	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem008window();
	}

	@Test(groups = "unit")
	public void Fill_some_windows() {
		this.assertWindow(5, 4, new int[] { 7, 3, 1, 6, 7 });
		this.assertWindow(5, 5, new int[] { 3, 1, 6, 7, 1 });
		this.assertWindow(5, 6, new int[] { 1, 6, 7, 1, 7 });
	}

	@Test(groups = "unit")
	public void Calc_product() {
		Assert.assertEquals(this.problem.calcProduct(new int[] { 7, 3, 1, 6, 7 }), 7 * 3 * 1 * 6 * 7);
	}

	private void assertWindow(int count, int end, int[] items) {
		int[] window = this.problem.fillWindow(count, end);
		for (int i = 0; i < count; i++) {
			Assert.assertEquals(window[i], items[i]);
		}
	}

	@Test(groups = "unit")
	public void Calc_maximum_product_window() {
		Assert.assertEquals(this.problem.findGreatestProductOf(5), 40824);
	}

}
