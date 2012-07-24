package hu.qwaevisz.delegate;

public class StringLengthCompare implements Comparator<String> {

	@Override
	public boolean compare(String o1, String o2) {		
		return (o1.length() < o2.length());
	}
	
}
