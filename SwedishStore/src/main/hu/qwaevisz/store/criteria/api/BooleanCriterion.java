package hu.qwaevisz.store.criteria.api;

public abstract class BooleanCriterion {

	protected final boolean	prescribedValue;

	public BooleanCriterion(boolean prescribedValue) {
		this.prescribedValue = prescribedValue;
	}

	public boolean isValid(boolean actual) {
		return (this.prescribedValue && actual) || (!this.prescribedValue && !actual);
	}

}
