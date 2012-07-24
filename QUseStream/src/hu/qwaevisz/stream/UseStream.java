package hu.qwaevisz.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

public class UseStream {

	public static String RESOURCES_DIR = "resources";
	public static String A_FILE_NAME = "a.txt";
	public static String B_FILE_NAME = "b.txt";
	public static String C_FILE_NAME = "c.txt";

	public static void UseFileReader(String filename) {
		FileReader fr = null;
		try {
			fr = new FileReader(filename);

			int i = 0;
			do {
				i = fr.read();
				if (i != -1) {
					// System.out.print(i);
					System.out.print((char) i);
				}
			} while (i != -1);

		} catch (FileNotFoundException e) {
			System.out.println("A file (" + filename + ") nem található [" + e.getLocalizedMessage() + "].");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	public static void UseFileReaderWithBufferedReader(String filename) {
		BufferedReader br = null;
		try {
			Reader fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String line = null;
			do {
				line = br.readLine();
				if (line != null) {
					System.out.println(line);
				}
			} while (line != null);

		} catch (FileNotFoundException e) {
			System.out.println("A file (" + filename + ") nem található [" + e.getLocalizedMessage() + "].");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	public static void UseFileWriter(String filename) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(filename);

			fw.write("szilva\n");
			fw.write("szõlõ\n");

		} catch (FileNotFoundException e) {
			System.out.println("A file (" + filename + ") nem található [" + e.getLocalizedMessage() + "].");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}

	public static void UseFileWriterWithPrintWriter(String filename) {
		PrintWriter pw = null;
		try {
			// CREATE --> new FileWriter(filename);
			// APPEND --> new FileWriter(filename,true);			
			FileWriter fw = new FileWriter(filename, true);
			pw = new PrintWriter(fw);

			pw.println("szilva");
			pw.println("szõlõ");

		} catch (FileNotFoundException e) {
			System.out.println("A file (" + filename + ") nem található [" + e.getLocalizedMessage() + "].");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			pw.close();
		}
	}

	public static void main(String[] args) {

		System.out.println("Use streams");

		System.out.println(">> Stream: FileReader <<");
		UseStream.UseFileReader(UseStream.RESOURCES_DIR + "/" + UseStream.A_FILE_NAME);

		System.out.println("\n>> Stream: FileReader  Filter: BufferedReader <<");
		UseStream.UseFileReaderWithBufferedReader(UseStream.RESOURCES_DIR + "/" + UseStream.A_FILE_NAME);

		System.out.println(">> Stream: FileWriter <<");
		UseStream.UseFileWriter(UseStream.RESOURCES_DIR + "/" + UseStream.B_FILE_NAME);

		File f = new File(UseStream.RESOURCES_DIR + "/" + UseStream.B_FILE_NAME);
		System.out.println("UseStream.NEWFILE_NAME length = " + f.length());
		if (f.canWrite()) {
			if (f.delete()) {
				System.out.println("File törlése: OK.");
			} else {
				System.out.println("File törlése: SIKERTELEN.");
			}
		}

		System.out.println(">> Stream: FileWriter  Filter: PrintWriter <<");
		UseStream.UseFileWriterWithPrintWriter(UseStream.RESOURCES_DIR + "/" + UseStream.C_FILE_NAME);
	}

}
