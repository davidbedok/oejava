package hu.qwaevisz.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Program extends java.lang.Object {

	private static final int MAX = 20;
	private static final int TASK_NUMBER = 3;
	private int opA;
	private int opB;
	private int result;
	private final Random rand;

	public static void main(String[] args) {
		Program iProg = new Program();
		iProg.generateOperations();
		System.out.print(iProg);
		iProg.setResult(Program.readInt());
		System.out.println(iProg.check());
		System.out.println("Result: " + iProg.getResult());

		int goodAnswer = 0;
		for (int i = 0; i < Program.TASK_NUMBER; i++) {

			iProg.generateOperations();
			System.out.print(iProg);
			iProg.setResult(Program.readInt());
			if (iProg.check()) {
				++goodAnswer;
			}

		}
		System.out.println("goodAnswer: " + goodAnswer);
	}

	public static int readInt() {
		int ret;
		String tmp = Program.readLine();
		try {
			ret = Integer.parseInt(tmp);
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException " + e.getLocalizedMessage());
			ret = 0;
		}
		return ret;
	}

	public static String readLine() {
		String ret = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			ret = br.readLine();
		} catch (IOException e) {
			System.out.println("IOException " + e.getLocalizedMessage());
		}
		return ret;
	}

	public Program() {
		System.out.println("Calculator instance created.");
		this.rand = new Random();
	}

	public boolean check() {
		return (this.opA + this.opB == this.result);
	}

	public void generateOperations() {
		this.opA = this.rand.nextInt(Program.MAX);
		this.opB = this.rand.nextInt(Program.MAX);
	}

	public int getResult() {
		return this.opA + this.opB;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return this.opA + " + " + this.opB + " = ";
	}

}
