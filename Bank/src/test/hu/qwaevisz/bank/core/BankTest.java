package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.exception.ClientIsNotUniqueException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest {

	private static final String TEST_CLIENT_NAME = "Lorem";
	private static final String TEST_OTHER_CLIENT_NAME = "Ipsum";

	private Bank bank;

	@BeforeMethod
	public void setup() {
		this.bank = new Bank();
	}

	@Test
	public void registerClient() throws ClientIsNotUniqueException {
		this.bank.add(TEST_CLIENT_NAME);
		final Client clientResult = this.bank.get(TEST_CLIENT_NAME);
		Assert.assertEquals(clientResult.getName(), TEST_CLIENT_NAME);
		Assert.assertEquals(this.bank.getNumberOfClients(), 1);
	}

	@Test
	public void registerTwoClients() throws ClientIsNotUniqueException {
		this.bank.add(TEST_CLIENT_NAME);
		this.bank.add(TEST_OTHER_CLIENT_NAME);
		Assert.assertEquals(this.bank.get(TEST_CLIENT_NAME).getName(), TEST_CLIENT_NAME);
		Assert.assertEquals(this.bank.get(TEST_OTHER_CLIENT_NAME).getName(), TEST_OTHER_CLIENT_NAME);
		Assert.assertEquals(this.bank.getNumberOfClients(), 2);
	}

	@Test
	public void nonExistingUserCheck() {
		Assert.assertNull(this.bank.get("Anonymous"));
		Assert.assertEquals(this.bank.getNumberOfClients(), 0);
	}

	@Test(enabled = true)
	public void twoClientsHaveTheSameNameButItIsNotSupported() {
		try {
			this.bank.add(TEST_CLIENT_NAME);
		} catch (final ClientIsNotUniqueException e) {
			Assert.fail();
		}
		Assert.assertEquals(this.bank.getNumberOfClients(), 1);
		try {
			this.bank.add(TEST_CLIENT_NAME);
			Assert.fail();
		} catch (final ClientIsNotUniqueException e) {
		}
		Assert.assertEquals(this.bank.getNumberOfClients(), 1);
	}

}
