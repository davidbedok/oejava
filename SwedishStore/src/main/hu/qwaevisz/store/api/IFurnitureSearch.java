package hu.qwaevisz.store.api;

import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;

public interface IFurnitureSearch {

	abstract void addRoomCriterion(Room... values);

	abstract void addMaterialCriterion(Material... values);

	abstract void addSizeWithCriterion(Double minValue, Double maxValue);

	abstract void addSizeHeightCriterion(Double minValue, Double maxValue);

	abstract void addSizeLengthCriterion(Double minValue, Double maxValue);

	abstract void addPriceCriterion(Double minValue, Double maxValue);

	abstract void addClassCriterion(Class<?>... clazzes);

	abstract void addCompactSizeCriterion(boolean prescribedValue);

	abstract void addBuiltInLampCriterion(boolean prescribedValue);

	abstract void addBedDoubleSizeCriterion(boolean prescribedValue);

	abstract void addBedMattressCriterion(Mattress... values);

	abstract void addTableNumberOfChairsCriterion(Integer minValue, Integer maxValue);

	abstract void addTableScratchResistantCriterion(boolean prescribedValue);

	abstract void addWardrobeDoorTypeCriterion(DoorType... values);

	abstract void addWardrobeMirrorCriterion(boolean prescribedValue);

	abstract void addWardrobeNumberOfShelvesCriterion(Integer minValue, Integer maxValue);

}
