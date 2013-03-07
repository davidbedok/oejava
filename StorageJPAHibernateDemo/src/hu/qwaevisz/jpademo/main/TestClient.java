package hu.qwaevisz.jpademo.main;

import hu.qwaevisz.jpademo.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestClient {
	private EntityManagerFactory	emf;
	private EntityManager			em;

	public static void main(String[] args) {
		TestClient c1 = new TestClient();
		c1.test();
	}

	private void test() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceHibernateDemoUnit");
		this.em = this.emf.createEntityManager();

		Person g = (Person) this.em.createQuery("select s from Person s where s.name = :pname").setParameter("pname", "david").getSingleResult();
		System.out.println(g.toString());

		this.em.close();
		this.emf.close();
	}
}