package hu.qwaevisz.guessing.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class Program {

	public static void main(String[] args) {
		System.out.println("# Start Guessing game Client..");
		try {
			new GameClient();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedOperationException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("# End Guessing game Client..");
	}

}
