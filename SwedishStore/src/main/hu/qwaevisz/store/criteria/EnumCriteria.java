package hu.qwaevisz.store.criteria;

import java.util.Arrays;
import java.util.EnumSet;

public class EnumCriteria<E extends Enum<E>> {

	protected EnumSet<E>	criteria;

	public void addCriteria(E... values) {
		if (values.length > 0) {
			this.criteria = EnumSet.copyOf(Arrays.asList(values));
		}
	}

	public boolean isValid(E value) {
		return (this.criteria == null || this.criteria.contains(value));
	}

}
