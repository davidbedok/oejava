package hu.qwaevisz.problem;

import hu.qwaevisz.dto.PythagoreanTriplet;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Problem009Test {

	private Problem009pythagorean	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem009pythagorean();
	}

	// @Test(groups = "unit")
	public void Print_all_square_numbers() {
		List<Integer> generateAllSquareNumberBelow = this.problem.generateAllSquareNumberBelow(1000);
		for (Integer value : generateAllSquareNumberBelow) {
			System.out.println(value);
		}
	}

	// @Test(groups = "unit")
	public void Print_all_Pythagorean_triplets() {
		List<PythagoreanTriplet> triplets = this.problem.findPythagoreanTriplets(1000);
		for (PythagoreanTriplet triplet : triplets) {
			System.out.println(triplet);
		}
	}

	@Test(groups = "unit")
	public void Find_sum() {
		PythagoreanTriplet triplet = this.problem.findSumOfPythagoreanTriplets(1000, 1000000);
		Assert.assertEquals(triplet.getA(), 200);
		Assert.assertEquals(triplet.getB(), 375);
		Assert.assertEquals(triplet.getC(), 425);
		Assert.assertEquals(triplet.product(), 31875000);
	}

}
