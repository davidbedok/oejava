package hu.qwaevisz.guessing.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CommunicationHelper {

	public static String receive(BufferedReader br) throws IOException {
		return br.readLine();
	}

	public static void send(PrintWriter pw, int code) {
		pw.println(Integer.valueOf(code).toString());
		pw.flush();
	}

	public static void send(PrintWriter pw, String message) {
		pw.println(message);
		pw.flush();
	}

}
