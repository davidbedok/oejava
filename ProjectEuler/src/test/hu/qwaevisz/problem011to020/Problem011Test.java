package hu.qwaevisz.problem011to020;

import hu.qwaevisz.dto.Quartet;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem011Test {

	private Problem011grid	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem011grid();
	}

	// @Test(groups = "unit")
	public void List_all_horizontal_quartets() {
		List<Quartet> allHorizontalQuartets = this.problem.getAllHorizontalQuartets();
		for (Quartet quartet : allHorizontalQuartets) {
			System.out.println(quartet);
		}
	}

	// @Test(groups = "unit")
	public void List_all_vertical_quartets() {
		List<Quartet> allVerticalQuartets = this.problem.getAllVerticalQuartets();
		for (Quartet quartet : allVerticalQuartets) {
			System.out.println(quartet);
		}
	}

	// @Test(groups = "unit")
	public void List_all_diagonal_left_quartets() {
		List<Quartet> allDiagonalLeftQuartets = this.problem.getAllDiagonalLeftQuartets();
		for (Quartet quartet : allDiagonalLeftQuartets) {
			System.out.println(quartet);
		}
	}

	// @Test(groups = "unit")
	public void List_all_diagonal_right_quartets() {
		List<Quartet> allDiagonalRightQuartets = this.problem.getAllDiagonalRightQuartets();
		for (Quartet quartet : allDiagonalRightQuartets) {
			System.out.println(quartet);
		}
	}

	@Test(groups = "unit")
	public void Get_the_maximum_product_of_quartets() {
		Assert.assertEquals(this.problem.getMaximumProductQuartets(), 70600674);
	}

}
