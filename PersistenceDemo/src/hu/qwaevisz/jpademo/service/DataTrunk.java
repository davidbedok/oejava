package hu.qwaevisz.jpademo.service;

import hu.qwaevisz.jpademo.model.Department;
import hu.qwaevisz.jpademo.model.PersonType;
import hu.qwaevisz.jpademo.model.trunk.DepartmentTrunk;
import hu.qwaevisz.jpademo.model.trunk.PersonTypeTrunk;

public class DataTrunk {

	private static DataTrunk instance = null;

	private final TrunkEngine trunkEngine;

	protected DataTrunk() {
		this.trunkEngine = new TrunkEngine();
		DemoService service = new DemoService();
		this.trunkEngine.addRelation(service, PersonType.class, PersonTypeTrunk.class);
		this.trunkEngine.addRelation(service, Department.class, DepartmentTrunk.class);
	}

	public PersonType map(PersonTypeTrunk trunk) {
		return (PersonType) this.trunkEngine.map(trunk);
	}

	public Department map(DepartmentTrunk trunk) {
		return (Department) this.trunkEngine.map(trunk);
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
