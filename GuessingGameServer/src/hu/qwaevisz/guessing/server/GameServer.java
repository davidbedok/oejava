package hu.qwaevisz.guessing.server;

import hu.qwaevisz.guessing.common.ConnectionConstants;
import hu.qwaevisz.guessing.common.Operation;
import hu.qwaevisz.guessing.common.SocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

public class GameServer {

	private static final int MAXIMUM_NUMBER = 100;

	private final Random random;
	private ServerSocket serverSocket;
	private SocketWrapper socketWrapper;
	private int fabricatedNumber;

	public GameServer(Random random) throws IOException {
		this.random = random;
		this.start(ConnectionConstants.SERVER_PORT);
		this.waitForClientToConnect();
	}

	private void start(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		System.out.println("Listening at port " + port);
	}

	private void waitForClientToConnect() throws IOException {
		this.socketWrapper = new SocketWrapper(this.serverSocket.accept());
		this.socketWrapper.send(Operation.SERVER_WELCOME,
				"Hello! What's your name?");
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
		case CLIENT_INTRODUCTION:
			String introduction = this.socketWrapper.receiveMessage();
			System.out.println("Client sent an introduction: " + introduction);
			int startIndex = introduction.indexOf("I'm") + 4;
			int endIndex = introduction.indexOf('.', startIndex);
			String name = introduction.substring(startIndex, endIndex);
			this.startGame(name);
			break;
		case CLIENT_TIP:
			String tipStr = this.socketWrapper.receiveMessage();
			System.out.println("Client sent a tip: " + tipStr);
			endGame = this.serverAnswer(tipStr);
			break;
		case CLIENT_KILL:
			System.out
					.println("The client wants to kill the server. Server will be terminated.");
			endGame = true;
			break;
		default:
			throw new UnsupportedOperationException();
		}
		return endGame;
	}

	private void startGame(String name) {
		this.fabricatedNumber = this.random.nextInt(GameServer.MAXIMUM_NUMBER);
		System.out.println("fabricatedNumber: " + this.fabricatedNumber);
		this.socketWrapper.send(Operation.SERVER_STARTGAME, name
				+ ", I thought a number between 1 and "
				+ GameServer.MAXIMUM_NUMBER + ". Try to figure out!");
	}

	private boolean serverAnswer(String tipStr) {
		boolean endGame = false;
		try {
			int tip = Integer.parseInt(tipStr);
			if (tip > this.fabricatedNumber) {
				this.socketWrapper.send(Operation.SERVER_ANSWER,
						"The number is less than " + tip + ".");
			} else if (tip < this.fabricatedNumber) {
				this.socketWrapper.send(Operation.SERVER_ANSWER,
						"The number is greater than " + tip + ".");
			} else {
				this.socketWrapper.send(Operation.SERVER_EXIT,
						"This is the number (" + tip + "). Congratulation!");
				endGame = true;
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return endGame;
	}

}
