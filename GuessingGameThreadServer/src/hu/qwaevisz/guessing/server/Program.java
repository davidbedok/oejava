package hu.qwaevisz.guessing.server;

import java.io.IOException;
import java.util.Random;

public class Program {

	public static void main(String[] args) {
		System.out.println("# Start Guessing game Server..");
		try {
			new GameServer(new Random());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("# End Guessing game Server..");
	}

}
