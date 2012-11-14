package hu.qwaevisz.problem011to020;

import hu.qwaevisz.util.FactorialCalculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * 
 * IMG: p_015.gif
 * 
 * How many routes are there through a 20x20 grid?
 * 
 */
public class Problem015pascal {

	private final FactorialCalculator	factorialCalc;

	public Problem015pascal() {
		this.factorialCalc = new FactorialCalculator();
	}

	public List<Long> pascalTriangle(long level) {
		if (level == 0) {
			return this.toList(1);
		} else if (level == 1) {
			return this.toList(1, 1);
		} else {
			List<Long> prevPascalTriangle = this.pascalTriangle(level - 1);
			List<Long> pascalTriangle = new ArrayList<Long>();
			pascalTriangle.add(1L);
			for (int i = 1; i < prevPascalTriangle.size(); i++) {
				pascalTriangle.add(prevPascalTriangle.get(i - 1) + prevPascalTriangle.get(i));
			}
			pascalTriangle.add(1L);
			return pascalTriangle;
		}
	}

	private List<Long> toList(long... elements) {
		List<Long> data = new ArrayList<Long>();
		for (long element : elements) {
			data.add(element);
		}
		return data;
	}

	public long centralElementOfPascalTriangle(int level) {
		long centralElement = 0;
		if (level % 2 == 0) {
			List<Long> pascalTriangle = this.pascalTriangle(level);
			return pascalTriangle.get(level / 2);
		}
		return centralElement;
	}

	public long bastionProblem(int squareSize) {
		return this.centralElementOfPascalTriangle(2 * squareSize);
	}

	public long bastionProblemByExpression(int squareSize) {
		long factSquareSize = this.factorialCalc.factorial(squareSize);
		return this.factorialCalc.factorial(squareSize * 2) / (factSquareSize * factSquareSize);
	}

	/**
	 * multinomial
	 * 
	 **/
	public BigInteger bastionProblemByExpression(BigInteger squareSize) {
		BigInteger factSquareSize = this.factorialCalc.factorial(squareSize);
		return this.factorialCalc.factorial(squareSize.multiply(new BigInteger("2"))).divide((factSquareSize.multiply(factSquareSize)));
	}
}
