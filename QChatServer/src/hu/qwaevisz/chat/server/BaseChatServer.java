package hu.qwaevisz.chat.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class BaseChatServer {

	public static void main(String[] args) {
		System.out.println("Start Chat Server Application");

		SortedMap<Integer, ChatMessage> history = new TreeMap<Integer, ChatMessage>();
		Integer order = 0;

		try {
			ServerSocket ss = new ServerSocket(CommonConstants.SERVER_PORT);
			System.out.println("Listening at port " + CommonConstants.SERVER_PORT);

			Operation opearation = null;
			while (!Operation.KILLSERVER.equals(opearation)) {
				/*
				 * Egy feldolgozott kliens keres utan ugyanarra a kliensre fog ismet varni. Kulon szalban lenne szukseges magat az acceptet, es magat a
				 * feldolgozast is vegezni.
				 */
				Socket s = ss.accept();

				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);

				// mandatory parameters
				String username = br.readLine();
				opearation = Operation.fromValue(br.readLine());
				// System.out.println("Accept communication from " + username + ". Operation: " + opearation);
				switch (opearation) {
				case NEWMESSAGE:
					// read chat message
					String newline = br.readLine();
					System.out.println("New message: " + newline);
					ChatMessage cm = new ChatMessage();
					cm.setCreateDate(new Date());
					cm.setMessage(newline);
					cm.setUsername(username);
					cm.setOrder(order);

					history.put(order, cm);
					System.out.println(cm);

					// write feedback
					CommonFunctions.send(pw, order.toString());
					order++;
					break;
				case LIST:
					Iterator<Integer> iterator = history.keySet().iterator();
					while (iterator.hasNext()) {
						Integer key = iterator.next();
						ChatMessage cmhist = history.get(key);
						CommonFunctions.send(pw, cmhist.toString());
					}
					// send EOF sign
					CommonFunctions.send(pw, CommonConstants.EOF);
					break;
				case EXIT:
					System.out.println(username + " close the client (exit).");
					break;
				}
				s.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End Chat Server Application");
	}

}
