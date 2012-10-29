package hu.qwaevisz.guessing.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

	public static String readLine(String question) {
		String ret = "";
		System.out.print(question);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			ret = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
