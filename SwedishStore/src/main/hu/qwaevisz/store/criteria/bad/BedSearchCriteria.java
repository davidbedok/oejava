package hu.qwaevisz.store.criteria.bad;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.furniture.Bed;

import java.util.Arrays;
import java.util.EnumSet;

public class BedSearchCriteria extends FurnitureSearchCriteria {

	private final EnumSet<Mattress>	mattresses;
	private Boolean					doubleSize;
	private Boolean					compactSize;
	private Boolean					builtInLamp;

	public BedSearchCriteria() {
		this.mattresses = EnumSet.noneOf(Mattress.class);
	}

	public void addRoomCriteria(Mattress... mattresses) {
		this.mattresses.addAll(Arrays.asList(mattresses));
	}

	public void addDoubleSizeConstraint(boolean value) {
		this.doubleSize = value;
	}

	public void addCompactSizeConstraint(boolean value) {
		this.compactSize = value;
	}

	public void addBuiltInLampConstraint(boolean value) {
		this.builtInLamp = value;
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = true;
		if (furniture != null) {
			if (furniture instanceof Bed) {
				Bed bed = (Bed) furniture;
				valid = super.isValid(bed) && this.isValidMattress(bed.getMattress()) && this.isValidDoubleSize(bed.isDoubleSize())
						&& this.isValidCompactSize(bed.isCompactSizeMode()) && this.isValidBuiltInLamp(bed.isBuiltInLamp());
			} else {
				valid = false;
			}
		}
		return valid;
	}

	private boolean isValidMattress(Mattress mattress) {
		return (this.mattresses.size() == 0 || this.mattresses.contains(mattress));
	}

	private boolean isValidDoubleSize(boolean value) {
		return this.doubleSize == null || this.doubleSize == value;
	}

	private boolean isValidCompactSize(boolean value) {
		return this.compactSize == null || this.compactSize == value;
	}

	private boolean isValidBuiltInLamp(boolean value) {
		return this.builtInLamp == null || this.builtInLamp == value;
	}

}
