package hu.qwaevisz.problem011to020;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem013Test {

	private Problem013writtensum	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem013writtensum(50);
	}

	@Test(groups = "unit")
	public void Check_cutting_numbers() {
		String[] numbers = this.problem.getNumbers();
		for (String number : numbers) {
			System.out.println(number);
		}
		Assert.assertEquals(numbers.length, 100);
		Assert.assertEquals(numbers[0], "37107287533902102798797998220837590246510135740250");
		Assert.assertEquals(numbers[99], "53503534226472524250874054075591789781264330331690");
	}

	@Test(groups = "unit")
	public void Add_columns_in_numbers() {
		String[] numbers = new String[3];
		numbers[0] = "521";
		numbers[1] = "442";
		numbers[2] = "343";
		Assert.assertEquals(this.problem.addColumn(numbers, 2), 6);
		Assert.assertEquals(this.problem.addColumn(numbers, 1), 10);
		Assert.assertEquals(this.problem.addColumn(numbers, 0), 12);
	}

	@Test(groups = "unit")
	public void Calc_maximum_digits() {
		Assert.assertEquals(this.problem.calcMaximumDigits(1, 3), 2);
		Assert.assertEquals(this.problem.calcMaximumDigits(1, 15), 3);
		Assert.assertEquals(this.problem.calcMaximumDigits(1, 100), 3);
		Assert.assertEquals(this.problem.calcMaximumDigits(2, 3), 3);
		Assert.assertEquals(this.problem.calcMaximumDigits(2, 15), 4);
		Assert.assertEquals(this.problem.calcMaximumDigits(2, 100), 4);
	}

	@Test(groups = "unit")
	public void Add_numbers_with_short_Strings() {
		Assert.assertEquals(this.problem.add(1, new String[] { "1", "2", "3" }), "6");
		Assert.assertEquals(this.problem.add(1, new String[] { "3", "4", "5" }), "12");
		Assert.assertEquals(this.problem.add(2, new String[] { "56", "78", "98" }), "232");
	}

	@Test(groups = "unit")
	public void Add_numbers() {
		Assert.assertEquals(this.problem.add(), "5537376230390876637302048746832985971773659831892672");
		Assert.assertEquals(this.problem.add().substring(0, 10), "5537376230");
	}
}
