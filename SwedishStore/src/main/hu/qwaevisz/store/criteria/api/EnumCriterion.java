package hu.qwaevisz.store.criteria.api;

import java.util.Arrays;
import java.util.EnumSet;

public abstract class EnumCriterion<E extends Enum<E>> {

	protected EnumSet<E>	criteria;

	public EnumCriterion(E... values) {
		if (values.length > 0) {
			this.criteria = EnumSet.copyOf(Arrays.asList(values));
		}
	}

	public boolean isValid(E value) {
		return (this.criteria == null || this.criteria.contains(value));
	}

}
