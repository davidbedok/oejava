package hu.qwaevisz.jpademo.service;

import hu.qwaevisz.jpademo.model.Person;
import hu.qwaevisz.jpademo.model.PersonType;
import hu.qwaevisz.jpademo.model.trunk.PersonTypeTrunk;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DemoService {

	private static final String UNIT_NAME = "PersistenceDemoUnit";

	private final EntityManagerFactory factory;
	private final EntityManager entityManager;

	public DemoService() {
		this.factory = Persistence.createEntityManagerFactory(DemoService.UNIT_NAME);
		this.entityManager = this.factory.createEntityManager();
	}

	public List<Person> listOfPerson() {
		TypedQuery<Person> query = this.entityManager.createQuery("SELECT p FROM Person p", Person.class);
		List<Person> people = query.getResultList();
		return people;
	}

	public List<PersonType> listOfPersonType() {
		TypedQuery<PersonType> query = this.entityManager.createQuery("SELECT t FROM PersonType t", PersonType.class);
		List<PersonType> people = query.getResultList();
		return people;
	}

	public <T> List<T> list(Class<T> clazz) {
		TypedQuery<T> query = this.entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t", clazz);
		List<T> list = query.getResultList();
		return list;
	}

	public PersonType getPersonType(int id) {
		PersonType personType = this.entityManager.find(PersonType.class, id);
		return personType;
	}

	public void insertPerson(String name, int age, PersonType personType) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(new Person(name, age, personType));
		transaction.commit();
	}

	public void insertPerson(String name, int age, int personTypeId) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(new Person(name, age, this.getPersonType(personTypeId)));
		transaction.commit();
	}

	public void insertPerson(String name, int age, PersonTypeTrunk personTypeTrunk) {
		PersonType personType = DataTrunk.getInstance().map(personTypeTrunk);

		EntityTransaction transaction = this.entityManager.getTransaction();
		transaction.begin();
		this.entityManager.persist(new Person(name, age, personType));
		transaction.commit();
	}

	public void close() {
		this.entityManager.close();
	}

}
