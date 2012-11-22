package hu.qwaevisz.storage.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonType {

	public static final String Q_LIST = "SELECT pet_id, pet_name FROM persontypes";

	private final int id;
	private final String name;

	public PersonType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name + " (" + this.id + ")";
	}

	public static List<PersonType> fromResultSet(ResultSet resultSet) throws SQLException {
		List<PersonType> listOfPersonTypes = new ArrayList<PersonType>();
		while (resultSet.next()) {
			int id = resultSet.getInt("pet_id");
			String name = resultSet.getString("pet_name");

			listOfPersonTypes.add(new PersonType(id, name));
		}
		return listOfPersonTypes;
	}

}
