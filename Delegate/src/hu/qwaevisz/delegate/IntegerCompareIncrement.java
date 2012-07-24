package hu.qwaevisz.delegate;

public class IntegerCompareIncrement implements Comparator<Integer> {

	@Override
	public boolean compare(Integer o1, Integer o2) {		
		return (o1 < o2);
	}
	
}
