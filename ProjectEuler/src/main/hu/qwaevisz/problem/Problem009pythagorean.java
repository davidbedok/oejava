package hu.qwaevisz.problem;

import hu.qwaevisz.dto.PythagoreanTriplet;

import java.util.ArrayList;
import java.util.List;

/**
 * A Pythagorean triplet is a set of three natural numbers, a b c, for which,
 * 
 * a^2 + b^2 = c^2
 * 
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 
 * Find the product abc.
 * 
 */
public class Problem009pythagorean {

	public List<Integer> generateAllSquareNumberBelow(int limit) {
		List<Integer> squareNumbers = new ArrayList<Integer>();
		int num = 1;
		int square = 1;
		while (square < limit) {
			squareNumbers.add(square);
			num++;
			square = num * num;
		}
		return squareNumbers;
	}

	public List<PythagoreanTriplet> findPythagoreanTriplets(int limit) {
		List<PythagoreanTriplet> triplets = new ArrayList<PythagoreanTriplet>();
		List<Integer> squareNumbers = this.generateAllSquareNumberBelow(limit);
		for (Integer a2 : squareNumbers) {
			for (Integer b2 : squareNumbers) {
				int c2 = a2 + b2;
				if (squareNumbers.contains(c2)) {
					triplets.add(new PythagoreanTriplet((int) Math.sqrt(a2), (int) Math.sqrt(b2), (int) Math.sqrt(c2)));
				}
			}
		}
		return triplets;
	}

	public PythagoreanTriplet findSumOfPythagoreanTriplets(int searchedSum, int limit) {
		PythagoreanTriplet result = null;
		List<PythagoreanTriplet> triplets = this.findPythagoreanTriplets(limit);
		for (PythagoreanTriplet triplet : triplets) {
			if (triplet.sum() == searchedSum) {
				result = triplet;
				break;
			}
		}
		return result;
	}

}
