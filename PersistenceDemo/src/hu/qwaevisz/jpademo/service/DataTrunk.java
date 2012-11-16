package hu.qwaevisz.jpademo.service;

import hu.qwaevisz.jpademo.model.Department;
import hu.qwaevisz.jpademo.model.PersonType;
import hu.qwaevisz.jpademo.model.trunk.DepartmentTrunk;
import hu.qwaevisz.jpademo.model.trunk.PersonTypeTrunk;
import hu.qwaevisz.jpademo.model.trunk.Trunkable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTrunk {

	private static DataTrunk instance = null;

	private final Map<Class<? extends Enum<?>>, Map<? extends Enum<?>, ? extends Trunkable>> map;

	protected DataTrunk() {
		DemoService service = new DemoService();
		this.map = new HashMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, ? extends Trunkable>>();
		this.addRelation(service, PersonType.class, PersonTypeTrunk.class);
		this.addRelation(service, Department.class, DepartmentTrunk.class);
	}

	private <T extends Trunkable, E extends Enum<E>> void addRelation(DemoService service, Class<T> clazz, Class<E> enumClazz) {
		this.map.put(enumClazz, this.init(service, clazz, enumClazz));
	}

	private <T extends Trunkable, E extends Enum<E>> Map<E, T> init(DemoService service, Class<T> clazz, Class<E> enumClazz) {
		Map<E, T> map = new HashMap<E, T>();
		List<T> items = service.list(clazz);
		for (T item : items) {
			map.put(Enum.valueOf(enumClazz, item.getName()), item);
		}
		return map;
	}

	public PersonType map(PersonTypeTrunk trunk) {
		return (PersonType) this.innerMap(trunk);
	}

	public Department map(DepartmentTrunk trunk) {
		return (Department) this.innerMap(trunk);
	}

	private <E extends Enum<E>> Trunkable innerMap(E trunk) {
		return this.map.get(trunk.getClass()).get(trunk);
	}

	public static DataTrunk getInstance() {
		if (DataTrunk.instance == null) {
			synchronized (DataTrunk.class) {
				if (DataTrunk.instance == null) {
					DataTrunk.instance = new DataTrunk();
				}
			}
		}
		return DataTrunk.instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
