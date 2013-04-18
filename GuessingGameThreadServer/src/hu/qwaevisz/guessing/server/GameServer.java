package hu.qwaevisz.guessing.server;

import hu.qwaevisz.guessing.common.ConnectionConstants;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

public class GameServer {

	private final Random	random;
	private ServerSocket	serverSocket;
	private int				threadNumber;

	public GameServer(Random random) throws IOException {
		this.random = random;
		this.threadNumber = 0;
		this.start(ConnectionConstants.SERVER_PORT);
		this.waitForClientToConnect();
	}

	@Override
	protected void finalize() throws Throwable {
		this.serverSocket.close();
	}

	private void start(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		System.out.println("Listening at port " + port);
	}

	private void waitForClientToConnect() throws IOException {
		while (true) {
			Thread gameThread = new Thread(new GameThread("game_" + this.threadNumber++, this.random, this.serverSocket.accept()));
			gameThread.start();
		}
	}

}
