package hu.qwaevisz.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class BaseChatClient {

	private static String consoleReadLine(String console) {
		String ret = "";
		System.out.print(console);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			ret = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	private static String userSend(String console, PrintWriter pw) {
		String message = BaseChatClient.consoleReadLine(console);
		CommonFunctions.send(pw, message);
		return message;
	}

	public static void main(String[] args) {
		System.out.println("Start Chat Client Application");
		Integer order = new Integer(0);
		try {
			String username = BaseChatClient.consoleReadLine("username: ");
			Operation operation = null;
			while (!Operation.EXIT.equals(operation)) {
				String opOrNewMessage = BaseChatClient.consoleReadLine(">");
				operation = Operation.fromValue(opOrNewMessage);
				if (Operation.NONE.equals(operation)) {
					operation = Operation.NEWMESSAGE;
				}

				Socket s = new Socket(CommonConstants.SERVER_HOST, CommonConstants.SERVER_PORT);

				InputStream is = s.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				OutputStream os = s.getOutputStream();
				PrintWriter pw = new PrintWriter(os);

				// mandatory parameters
				CommonFunctions.send(pw, username);
				CommonFunctions.send(pw, operation);
				switch (operation) {
				case LIST:
					String newline = "";
					while (!newline.equalsIgnoreCase(CommonConstants.EOF)) {
						newline = CommonFunctions.receive(br);
						if (!newline.equalsIgnoreCase(CommonConstants.EOF)) {
							System.out.println(newline);
						}
					}
					break;
				case NEWMESSAGE:
					CommonFunctions.send(pw, opOrNewMessage);
					String orderStr = CommonFunctions.receive(br);
					order = Integer.parseInt(orderStr);
					System.out.println("-- feedback (order of message): " + order);
					break;
				}
				s.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End Chat Client Application");
	}

}
