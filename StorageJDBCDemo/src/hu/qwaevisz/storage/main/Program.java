package hu.qwaevisz.storage.main;

import hu.qwaevisz.storage.model.Person;
import hu.qwaevisz.storage.model.PersonType;

import java.sql.SQLException;
import java.util.List;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DemoService service = new DemoService();
		List<PersonType> listAllPersonTypes = service.listAllPersonTypes();
		for (PersonType personType : listAllPersonTypes) {
			System.out.println(personType);
		}

		service.insertPerson(new Person("fwegger", 56, listAllPersonTypes.get(0)));

	}

}
