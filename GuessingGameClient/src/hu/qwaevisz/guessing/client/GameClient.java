package hu.qwaevisz.guessing.client;

import hu.qwaevisz.guessing.common.ConnectionConstants;
import hu.qwaevisz.guessing.common.Operation;
import hu.qwaevisz.guessing.common.SocketWrapper;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {

	private final SocketWrapper	socketWrapper;

	public GameClient() throws UnknownHostException, IOException {
		Socket socket = new Socket(ConnectionConstants.SERVER_HOST, ConnectionConstants.SERVER_PORT);
		this.socketWrapper = new SocketWrapper(socket);
		this.gameCycle();
	}

	private void gameCycle() throws IOException {
		while (!this.processOperation(this.socketWrapper.receiveOperation())) {
		}
		this.socketWrapper.close();
	}

	private boolean processOperation(Operation operation) throws IOException {
		boolean endGame = false;
		switch (operation) {
			case SERVER_WELCOME:
				String welcome = this.socketWrapper.receiveMessage();
				System.out.println(welcome);
				String name = ConsoleHelper.readLine("Your name? : ");
				this.socketWrapper.send(Operation.CLIENT_INTRODUCTION, "Hello! My name is " + name + ".");
				break;
			case SERVER_STARTGAME:
				String message = this.socketWrapper.receiveMessage();
				System.out.println(message);
				endGame = this.tip();
				break;
			case SERVER_ANSWER:
				String answer = this.socketWrapper.receiveMessage();
				System.out.println("server: " + answer);
				endGame = this.tip();
				break;
			case SERVER_EXIT:
				String exitMessage = this.socketWrapper.receiveMessage();
				System.out.println(exitMessage);
				endGame = true;
				break;
			default:
				throw new UnsupportedOperationException();
		}
		return endGame;
	}

	private boolean tip() {
		int tip = 0;
		boolean isKill = false;
		do {
			String tipStr = ConsoleHelper.readLine("Your tip? : ");
			if (!tipStr.toLowerCase().equals("kill")) {
				try {
					tip = Integer.parseInt(tipStr);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
			} else {
				isKill = true;
			}
		} while ((tip == 0) && (!isKill));
		if (isKill) {
			this.socketWrapper.send(Operation.CLIENT_KILL);
		} else {
			this.socketWrapper.send(Operation.CLIENT_TIP, Integer.valueOf(tip).toString());
		}
		return isKill;
	}

}
