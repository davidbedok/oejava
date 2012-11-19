package hu.qwaevisz.jpademo.service;

import hu.qwaevisz.jpademo.model.trunk.Trunkable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrunkEngine {

	private final Map<Class<? extends Enum<?>>, Map<? extends Enum<?>, ? extends Trunkable>> map;

	public TrunkEngine() {
		this.map = new HashMap<Class<? extends Enum<?>>, Map<? extends Enum<?>, ? extends Trunkable>>();
	}

	public <T extends Trunkable, E extends Enum<E>> void addRelation(DemoService service, Class<T> clazz, Class<E> enumClazz) {
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

	public <E extends Enum<E>> Trunkable map(E trunk) {
		return this.map.get(trunk.getClass()).get(trunk);
	}

}
