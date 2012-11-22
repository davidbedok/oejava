package hu.qwaevisz.storage.main;

import hu.qwaevisz.storage.helper.ConnectionWrapper;
import hu.qwaevisz.storage.model.Person;
import hu.qwaevisz.storage.model.PersonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DemoService {

	private final ConnectionWrapper connection;

	public DemoService() throws ClassNotFoundException, SQLException {
		this.connection = new ConnectionWrapper();
	}

	public List<PersonType> listAllPersonTypes() throws SQLException {
		Statement statement = this.connection.createStatement();
		ResultSet resultSet = statement.executeQuery(PersonType.Q_LIST);
		List<PersonType> listOfPersonTypes = PersonType.fromResultSet(resultSet);
		resultSet.close();
		statement.close();
		return listOfPersonTypes;
	}

	public void insertPerson(Person person) throws SQLException {
		PreparedStatement statement = this.connection.createPrepareStatement(Person.Q_INSERT);
		person.setStatement(statement);
		statement.executeUpdate();
		// this.connection.commit();
		statement.close();
	}

}
