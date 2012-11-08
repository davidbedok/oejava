package hu.qwaevisz.problem011to020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n n/2 (n is even)
 * 
 * n 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 40 20 10 5 16 8 4 2 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought
 * that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */
public class Problem014collatz {

	private final Map<Long, Long>	numberOfTerms;

	public Problem014collatz() {
		this.numberOfTerms = new TreeMap<Long, Long>();
		this.numberOfTerms.put(1L, 1L);
	}

	public long nextTerm(long value) {
		if (value % 2 == 0) {
			return value / 2;
		} else {
			return 3 * value + 1;
		}
	}

	public void numberOfTerm(long value, long limit, long heapSpaceLimit) {
		// System.out.println("start: " + value);
		if (!this.numberOfTerms.containsKey(value)) {
			int size = -1;
			List<Long> chainToStop = new ArrayList<Long>();
			long actValue = value;
			chainToStop.add(actValue);
			boolean find = false;
			do {
				long nextValue = this.nextTerm(actValue);
				// System.out.println("nextValue: " + nextValue);
				if (this.numberOfTerms.containsKey(nextValue)) {
					long findNumberOfTerms = this.numberOfTerms.get(nextValue);
					if (chainToStop != null) {
						int j = 1;
						for (int i = chainToStop.size() - 1; i >= 0; i--) {
							if (chainToStop.get(i) < limit) {
								this.numberOfTerms.put(chainToStop.get(i), findNumberOfTerms + j);
								// System.out.println("new key: " + chainToStop.get(i) + " - value: " + (findNumberOfTerms + j));
							}
							j++;
						}
					} else {
						// System.out.println("new key (only): " + value + " - value: " + (findNumberOfTerms + size));
						this.numberOfTerms.put(value, findNumberOfTerms + size);
					}
					find = true;
				} else {
					actValue = nextValue;
					if ((chainToStop != null) && (chainToStop.size() < heapSpaceLimit)) {
						chainToStop.add(actValue);
					} else if (chainToStop != null) {
						size = chainToStop.size() + 1;
						chainToStop = null;
					} else {
						size++;
					}
				}
			} while (!find);
		}
	}

	public void numberOfTermWithoutLimits(long value) {
		// System.out.println("start: " + value);
		if (!this.numberOfTerms.containsKey(value)) {
			List<Long> chainToStop = new ArrayList<Long>();
			long actValue = value;
			chainToStop.add(actValue);
			boolean find = false;
			do {
				long nextValue = this.nextTerm(actValue);
				// System.out.println("nextValue: " + nextValue);
				if (this.numberOfTerms.containsKey(nextValue)) {
					long findNumberOfTerms = this.numberOfTerms.get(nextValue);
					int j = 1;
					for (int i = chainToStop.size() - 1; i >= 0; i--) {
						this.numberOfTerms.put(chainToStop.get(i), findNumberOfTerms + j);
						// System.out.println("new key: " + chainToStop.get(i) + " - value: " + (findNumberOfTerms + j));
						j++;
					}
					find = true;
				} else {
					actValue = nextValue;
					chainToStop.add(actValue);
				}
			} while (!find);
		}
	}

	public void calcNumberOfTerms(long limit, long heapSpaceLimit) {
		for (int i = 2; i < limit; i++) {
			this.numberOfTerm(i, limit, heapSpaceLimit);
		}
	}

	public void calcNumberOfTermsWithoutLimits(long limit) {
		for (int i = 2; i < limit; i++) {
			this.numberOfTermWithoutLimits(i);
		}
	}

	public long maximumNumberOfTerm(long limit) {
		long maximum = this.numberOfTerms.get(1L);
		long maxKey = 1;
		for (long i = 2; i < limit; i++) {
			if (maximum < this.numberOfTerms.get(i)) {
				maximum = this.numberOfTerms.get(i);
				maxKey = i;
			}
		}
		System.out.println("maxKey: " + maxKey);
		return maximum;
	}

	public long maximumNumber(long limit) {
		long maximum = this.numberOfTerms.get(1L);
		long maxKey = 1;
		for (long i = 2; i < limit; i++) {
			if (maximum < this.numberOfTerms.get(i)) {
				maximum = this.numberOfTerms.get(i);
				maxKey = i;
			}
		}
		return maxKey;
	}

	public long getNumberOfTerms(long value) {
		return this.numberOfTerms.get(value);
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(100);
		for (Long key : this.numberOfTerms.keySet()) {
			Long value = this.numberOfTerms.get(key);
			info.append("(" + key + " - " + value + ")\n");
		}
		return info.toString();
	}

}
