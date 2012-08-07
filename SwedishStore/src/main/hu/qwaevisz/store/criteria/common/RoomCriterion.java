package hu.qwaevisz.store.criteria.common;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.criteria.api.EnumCriterion;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;

public class RoomCriterion extends EnumCriterion<Room> implements FurnitureCriterion {

	public RoomCriterion(Room... values) {
		super(values);
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		return super.isValid(furniture.getRoom());
	}

}
