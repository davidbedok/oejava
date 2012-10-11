package hu.qwaevisz.problem001to010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
 * 
 * 9009 = 91 x 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author edvibed
 * 
 */
public class Problem004palidrom {

	public boolean isPalidromNumber(int number) {
		String numberStr = "" + number;
		int len = numberStr.length();
		int i = 0;
		while ((i <= len / 2) && numberStr.charAt(i) == numberStr.charAt(len - 1 - i)) {
			i++;
		}
		return i > len / 2;
	}

	public List<Integer> findProductPalidroms(int maxLeftMultiplier, int maxRightMultiplier) {
		List<Integer> palidroms = new ArrayList<Integer>();
		for (int i = 1; i < maxLeftMultiplier; i++) {
			for (int j = i; j < maxRightMultiplier; j++) {
				int number = i * j;
				if (this.isPalidromNumber(number)) {
					palidroms.add(number);
				}
			}
		}
		return palidroms;
	}

	public int getMaximumPalidroms(int maxLeftMultiplier, int maxRightMultiplier) {
		List<Integer> productPalidroms = this.findProductPalidroms(maxLeftMultiplier, maxRightMultiplier);
		return Collections.max(productPalidroms);
	}

}
