package hu.qwaevisz.guessing.server;

import hu.qwaevisz.guessing.common.Operation;
import hu.qwaevisz.guessing.common.SocketWrapper;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class GameThread extends Thread {

	private static final String	MY_NAME_IS		= "My name is";
	private static final int	MAXIMUM_NUMBER	= 100;

	private final Random		random;
	private final SocketWrapper	socketWrapper;
	private int					fabricatedNumber;
	private String				name;

	public GameThread(String theadName, Random random, Socket socket) throws IOException {
		super(theadName);
		this.random = random;
		this.socketWrapper = new SocketWrapper(socket);
	}

	@Override
	public void run() {
		System.out.println("Thread (" + Thread.currentThread().getName() + ") start.");
		this.socketWrapper.send(Operation.SERVER_WELCOME, "Hello! What's your name?");
		try {
			this.gameCycle();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
		}
		System.out.println("Thread (" + Thread.currentThread().getName() + ") end.");
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
				int startIndex = introduction.indexOf(MY_NAME_IS) + MY_NAME_IS.length() + 1;
				int endIndex = introduction.indexOf('.', startIndex);
				this.name = introduction.substring(startIndex, endIndex);
				this.startGame();
				break;
			case CLIENT_TIP:
				String tipStr = this.socketWrapper.receiveMessage();
				System.out.println("Client (" + this.name + ") sent a tip: " + tipStr);
				endGame = this.serverAnswer(tipStr);
				break;
			case CLIENT_KILL:
				System.out.println("The client (" + this.name + ") wants to kill the server. Server will be terminated.");
				endGame = true;
				break;
			default:
				throw new UnsupportedOperationException();
		}
		return endGame;
	}

	private void startGame() {
		this.fabricatedNumber = this.random.nextInt(GameThread.MAXIMUM_NUMBER);
		System.out.println("FabricatedNumber for " + this.name + ": " + this.fabricatedNumber);
		this.socketWrapper.send(Operation.SERVER_STARTGAME, this.name + ", I thought a number between 1 and " + GameThread.MAXIMUM_NUMBER + ". Try to figure out!");
	}

	private boolean serverAnswer(String tipStr) {
		boolean endGame = false;
		try {
			int tip = Integer.parseInt(tipStr);
			if (tip > this.fabricatedNumber) {
				this.socketWrapper.send(Operation.SERVER_ANSWER, "The number is less than " + tip + ".");
			} else if (tip < this.fabricatedNumber) {
				this.socketWrapper.send(Operation.SERVER_ANSWER, "The number is greater than " + tip + ".");
			} else {
				this.socketWrapper.send(Operation.SERVER_EXIT, "This is the number (" + tip + "). Congratulation!");
				endGame = true;
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return endGame;
	}

}
