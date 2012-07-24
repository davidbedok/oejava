package hu.qwaevisz.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CommonFunctions {

	public static String receive(BufferedReader br) {
		String ret = "";
		try {
			ret = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void send(PrintWriter pw, Operation op) {
		pw.println(op.toString());
		pw.flush();
	}

	public static void send(PrintWriter pw, String message) {
		pw.println(message);
		pw.flush();
	}

}
