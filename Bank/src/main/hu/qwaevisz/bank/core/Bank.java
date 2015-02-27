package hu.qwaevisz.bank.core;

import hu.qwaevisz.bank.exception.ClientIsNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private final List<Client> clients;

	public Bank() {
		this.clients = new ArrayList<Client>();
	}

	public int getNumberOfClients() {
		return this.clients.size();
	}

	public void add(final String clientName) throws ClientIsNotUniqueException {
		if (this.get(clientName) == null) {
			this.add(new Client(clientName));
		} else {
			throw new ClientIsNotUniqueException();
		}
	}

	private void add(final Client client) {
		this.clients.add(client);
	}

	public Client get(final String clientName) {
		Client result = null;
		for (final Client client : this.clients) {
			if (client.getName().equals(clientName)) {
				result = client;
				break;
			}
		}
		return result;
	}

}
