package hu.qwaevisz.problem011to020;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * -Xms128m -Xmx256m
 * 
 * @author edvibed
 * 
 */
public class Problem014Test {

	private Problem014collatz	problem;

	@BeforeMethod
	public void setup() {
		this.problem = new Problem014collatz();
	}

	@Test(groups = "unit")
	public void Check_next_term() {
		Assert.assertEquals(this.problem.nextTerm(13), 40);
		Assert.assertEquals(this.problem.nextTerm(40), 20);
	}

	@Test(groups = "unit")
	public void Check_number_of_term_standalone() {
		this.problem.numberOfTerm(113383, 200000, 1);
		Assert.assertEquals(this.problem.getNumberOfTerms(113383), 248);
		this.problem.numberOfTerm(138367, 200000, 1);
		Assert.assertEquals(this.problem.getNumberOfTerms(138367), 163);
	}

	@Test(groups = "unit")
	public void Number_of_term() {
		this.callNumberOfTermsUnder13(1000, 100);
		this.checkNumberOfTermsUnder13();
	}

	@Test(groups = "unit")
	public void Number_of_term_testcase2() {
		this.callNumberOfTermsUnder13(100, 5);
		this.checkNumberOfTermsUnder13();
	}

	private void callNumberOfTermsUnder13(int limit, int heapSpaceLimit) {
		this.problem.numberOfTerm(2, limit, heapSpaceLimit);
		this.problem.numberOfTerm(3, limit, heapSpaceLimit);
		this.problem.numberOfTerm(4, limit, heapSpaceLimit);
		this.problem.numberOfTerm(5, limit, heapSpaceLimit);
		this.problem.numberOfTerm(6, limit, heapSpaceLimit);
		this.problem.numberOfTerm(7, limit, heapSpaceLimit);
		this.problem.numberOfTerm(8, limit, heapSpaceLimit);
		this.problem.numberOfTerm(9, limit, heapSpaceLimit);
		this.problem.numberOfTerm(10, limit, heapSpaceLimit);
		this.problem.numberOfTerm(11, limit, heapSpaceLimit);
		this.problem.numberOfTerm(12, limit, heapSpaceLimit);
		this.problem.numberOfTerm(13, limit, heapSpaceLimit);
	}

	private void checkNumberOfTermsUnder13() {
		Assert.assertEquals(this.problem.getNumberOfTerms(1), 1);
		Assert.assertEquals(this.problem.getNumberOfTerms(2), 2);
		Assert.assertEquals(this.problem.getNumberOfTerms(3), 8);
		Assert.assertEquals(this.problem.getNumberOfTerms(4), 3);
		Assert.assertEquals(this.problem.getNumberOfTerms(5), 6);
		Assert.assertEquals(this.problem.getNumberOfTerms(6), 9);
		Assert.assertEquals(this.problem.getNumberOfTerms(7), 17);
		Assert.assertEquals(this.problem.getNumberOfTerms(8), 4);
		Assert.assertEquals(this.problem.getNumberOfTerms(9), 20);
		Assert.assertEquals(this.problem.getNumberOfTerms(10), 7);
		Assert.assertEquals(this.problem.getNumberOfTerms(11), 15);
		Assert.assertEquals(this.problem.getNumberOfTerms(12), 10);
		Assert.assertEquals(this.problem.getNumberOfTerms(13), 10);
	}

	@Test(groups = "unit")
	public void Get_maximum_number_of_term_under_one_million() {
		long limit = 1000000;
		long heapSpaceLimit = 1000;
		this.problem.calcNumberOfTerms(limit, heapSpaceLimit);
		Assert.assertEquals(this.problem.maximumNumber(limit), 837799);
		Assert.assertEquals(this.problem.getNumberOfTerms(13), 10);
		Assert.assertEquals(this.problem.getNumberOfTerms(837799), 525);
	}

	@Test(groups = "unit")
	public void Get_maximum_number_of_term_under_one_million_without_limits() {
		long limit = 1000000;
		this.problem.calcNumberOfTermsWithoutLimits(limit);
		Assert.assertEquals(this.problem.maximumNumber(limit), 837799);
		Assert.assertEquals(this.problem.getNumberOfTerms(13), 10);
		Assert.assertEquals(this.problem.getNumberOfTerms(837799), 525);
	}

}
