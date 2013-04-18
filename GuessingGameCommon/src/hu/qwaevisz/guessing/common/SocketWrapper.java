package hu.qwaevisz.guessing.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketWrapper {

	private final Socket			socket;

	private final InputStream		inputStream;
	private final InputStreamReader	inputStreamReader;
	private final BufferedReader	bufferedReader;

	private final OutputStream		outputStream;
	private final PrintWriter		printWriter;

	public SocketWrapper(Socket socket) throws IOException {
		this.socket = socket;

		this.inputStream = this.socket.getInputStream();
		this.inputStreamReader = new InputStreamReader(this.inputStream);
		this.bufferedReader = new BufferedReader(this.inputStreamReader);

		this.outputStream = this.socket.getOutputStream();
		this.printWriter = new PrintWriter(this.outputStream);
	}

	public void send(Operation operation) {
		this.send(operation, null);
	}

	public void send(Operation operation, String message) {
		// System.out.println("INFO: send(" + operation + ", " + message + ")");
		CommunicationHelper.send(this.printWriter, operation.getCode());
		if (message != null) {
			CommunicationHelper.send(this.printWriter, message);
		}
	}

	public Operation receiveOperation() throws IOException {
		Operation operation = Operation.getDefault();
		String receiveStr = CommunicationHelper.receive(this.bufferedReader);
		// System.out.println("INFO: receiveOperation() str: " + receiveStr);
		try {
			operation = Operation.fromCode(Integer.parseInt(receiveStr));
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		// System.out.println("INFO: receiveOperation() op: " + operation);
		return operation;
	}

	public String receiveMessage() throws IOException {
		String message = CommunicationHelper.receive(this.bufferedReader);
		// System.out.println("INFO: receiveMessage() " + message);
		return message;
	}

	public void close() throws IOException {
		// System.out.println("INFO: close()");
		this.socket.close();
	}

}
