package hu.qwaevisz.store.engine;

import hu.qwaevisz.store.api.AbstractFurniture;
import hu.qwaevisz.store.api.IFurnitureSearch;
import hu.qwaevisz.store.common.DoorType;
import hu.qwaevisz.store.common.Material;
import hu.qwaevisz.store.common.Mattress;
import hu.qwaevisz.store.common.Room;
import hu.qwaevisz.store.criteria.api.FurnitureCriterion;
import hu.qwaevisz.store.criteria.common.BuiltInLampCriterion;
import hu.qwaevisz.store.criteria.common.ClassCriterion;
import hu.qwaevisz.store.criteria.common.CompactSizeCriterion;
import hu.qwaevisz.store.criteria.common.MaterialCriterion;
import hu.qwaevisz.store.criteria.common.PriceCriterion;
import hu.qwaevisz.store.criteria.common.RoomCriterion;
import hu.qwaevisz.store.criteria.common.SizeHeightCriterion;
import hu.qwaevisz.store.criteria.common.SizeLengthCriterion;
import hu.qwaevisz.store.criteria.common.SizeSurfaceCriterion;
import hu.qwaevisz.store.criteria.common.SizeWidthCriterion;
import hu.qwaevisz.store.criteria.spec.BedDoubleSizeCriterion;
import hu.qwaevisz.store.criteria.spec.BedMattressCriterion;
import hu.qwaevisz.store.criteria.spec.TableNumberOfChairsCriterion;
import hu.qwaevisz.store.criteria.spec.TableScratchResistantCriterion;
import hu.qwaevisz.store.criteria.spec.WardrobeDoorTypeCriterion;
import hu.qwaevisz.store.criteria.spec.WardrobeMirrorCriterion;
import hu.qwaevisz.store.criteria.spec.WardrobeNumberOfShelvesCriterion;

import java.util.ArrayList;
import java.util.List;

public class FurnitureSearch implements IFurnitureSearch, FurnitureCriterion {

	private final List<FurnitureCriterion>	criteria;

	public FurnitureSearch() {
		this.criteria = new ArrayList<FurnitureCriterion>();
	}

	public FurnitureSearch(FurnitureCriterion criterion) {
		this();
		this.addCriterion(criterion);
	}

	public FurnitureSearch(FurnitureSearch baseSearch) {
		this();
		this.addFurnitureSearchCriterion(baseSearch);
	}

	// private
	public void addCriterion(FurnitureCriterion criterion) {
		if (!this.criteria.contains(criterion)) {
			this.criteria.add(criterion);
		}
	}

	public FurnitureSearch add(FurnitureCriterion criterion) {
		if (!this.criteria.contains(criterion)) {
			this.criteria.add(criterion);
		}
		return this;
	}

	@Override
	public void addRoomCriterion(Room... values) {
		this.addCriterion(new RoomCriterion(values));
	}

	@Override
	public void addMaterialCriterion(Material... values) {
		this.addCriterion(new MaterialCriterion(values));
	}

	@Override
	public void addSizeWithCriterion(Double minValue, Double maxValue) {
		this.addCriterion(new SizeWidthCriterion(minValue, maxValue));
	}

	@Override
	public void addSizeHeightCriterion(Double minValue, Double maxValue) {
		this.addCriterion(new SizeHeightCriterion(minValue, maxValue));
	}

	@Override
	public void addSizeLengthCriterion(Double minValue, Double maxValue) {
		this.addCriterion(new SizeLengthCriterion(minValue, maxValue));
	}

	@Override
	public void addPriceCriterion(Double minValue, Double maxValue) {
		this.addCriterion(new PriceCriterion(minValue, maxValue));
	}

	@Override
	public void addClassCriterion(Class<?>... clazzes) {
		this.addCriterion(new ClassCriterion(clazzes));
	}

	@Override
	public void addCompactSizeCriterion(boolean prescribedValue) {
		this.addCriterion(new CompactSizeCriterion(prescribedValue));
	}

	@Override
	public void addBuiltInLampCriterion(boolean prescribedValue) {
		this.addCriterion(new BuiltInLampCriterion(prescribedValue));
	}

	@Override
	public void addBedDoubleSizeCriterion(boolean prescribedValue) {
		this.addCriterion(new BedDoubleSizeCriterion(prescribedValue));
	}

	@Override
	public void addBedMattressCriterion(Mattress... values) {
		this.addCriterion(new BedMattressCriterion(values));
	}

	@Override
	public void addTableNumberOfChairsCriterion(Integer minValue, Integer maxValue) {
		this.addCriterion(new TableNumberOfChairsCriterion(minValue, maxValue));
	}

	@Override
	public void addTableScratchResistantCriterion(boolean prescribedValue) {
		this.addCriterion(new TableScratchResistantCriterion(prescribedValue));
	}

	@Override
	public void addWardrobeDoorTypeCriterion(DoorType... values) {
		this.addCriterion(new WardrobeDoorTypeCriterion(values));
	}

	@Override
	public void addWardrobeMirrorCriterion(boolean prescribedValue) {
		this.addCriterion(new WardrobeMirrorCriterion(prescribedValue));
	}

	@Override
	public void addWardrobeNumberOfShelvesCriterion(Integer minValue, Integer maxValue) {
		this.addCriterion(new WardrobeNumberOfShelvesCriterion(minValue, maxValue));
	}

	public void addFurnitureSearchCriterion(FurnitureSearch search) {
		this.addCriterion(search);
	}

	public void addSizeSurfaceCriterion(Double minValue, Double maxValue) {
		this.addCriterion(new SizeSurfaceCriterion(minValue, maxValue));
	}

	@Override
	public boolean isValid(AbstractFurniture furniture) {
		boolean valid = true;
		for (FurnitureCriterion criterion : this.criteria) {
			if (!criterion.isValid(furniture)) {
				valid = false;
				break;
			}
		}
		return valid;
	}

	public static FurnitureSearch create(FurnitureCriterion... criteria) {
		FurnitureSearch search = new FurnitureSearch();
		for (FurnitureCriterion criterion : criteria) {
			search.addCriterion(criterion);
		}
		return search;
	}

}
