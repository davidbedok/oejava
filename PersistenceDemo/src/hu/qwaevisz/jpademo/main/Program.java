package hu.qwaevisz.jpademo.main;

import hu.qwaevisz.jpademo.model.Department;
import hu.qwaevisz.jpademo.model.Person;
import hu.qwaevisz.jpademo.model.PersonType;
import hu.qwaevisz.jpademo.model.trunk.DepartmentTrunk;
import hu.qwaevisz.jpademo.model.trunk.PersonTypeTrunk;
import hu.qwaevisz.jpademo.service.DataTrunk;
import hu.qwaevisz.jpademo.service.DemoService;

import java.util.List;

public class Program {

	private static void listOfPeople(DemoService service) {
		System.out.println("# People");
		List<Person> people = service.listOfPerson();
		for (Person person : people) {
			System.out.println(person);
		}
	}

	private static void listOfPersontypes(DemoService service) {
		System.out.println("# Persontypes");
		List<PersonType> types = service.listOfPersonType();
		for (PersonType type : types) {
			System.out.println(type);
		}
	}

	// private static void insertPerson(DemoService service) {
	// PersonType type = service.getPersonType(10);
	// service.insertPerson("Zeno100", 11, type);
	// }

	private static void insertPersonViaEnum(DemoService service) {
		service.insertPerson("Richard10", 24, PersonTypeTrunk.ARCHITECT);
	}

	public static void main(String[] args) {
		DemoService service = new DemoService();
		Program.listOfPeople(service);
		Program.listOfPersontypes(service);
		// Program.insertPerson(service);
		Program.insertPersonViaEnum(service);

		PersonType personType = DataTrunk.getInstance().map(PersonTypeTrunk.DEVELOPER);
		System.out.println(personType);

		Department department = DataTrunk.getInstance().map(DepartmentTrunk.HR);
		System.out.println(department);

		service.close();
	}
}
