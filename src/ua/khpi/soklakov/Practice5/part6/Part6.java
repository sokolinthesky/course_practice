package ua.khpi.soklakov.Practice5.part6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part6 {

	private static File file;
	private static RandomAccessFile raf;
	private static int pointer = 0;

	/**
	 * Constructor init fields and delete file if exist.
	 */
	public Part6() {
		if (file != null) {
			try {
				delete(file.getName());
				System.out.println("file delete");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (file == null && raf == null) {

			Part6.file = new File("part6.txt");
			try {
				Part6.raf = new RandomAccessFile(file, "rw");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new Part6();
		MyThread[] threads = new MyThread[10];

		for (int i = 0; i <= 9; i++) {
			Integer number = i;
			MyThread thread = new MyThread(number.toString(), pointer);
			threads[i] = thread;
			thread.start();
			pointer += 21;
		}
		
		for (MyThread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		raf.close();

		System.out.println(getStringFromFile(file.getName()));
	}

	/**
	 * Method write to file specified string from specified pointer.
	 * 
	 * @param pointer
	 *            specified pointer.
	 * @param string
	 *            specified string.
	 * @throws IOException
	 */
	public static void writeToFile(int pointer, String string) throws IOException {
		synchronized (raf) {
			raf.seek(pointer);
			raf.write(string.getBytes());
		}
	}

	/**
	 * Generation string of specified number.
	 * 
	 * @param number
	 *            specified number.
	 * @return string with size of 20 consist of specified number.
	 */
	public static String generateString(String number) {
		String result = "";
		for (int i = 0; i < 20; i++) {
			result = result.concat(number);
		}
		result = result.concat(System.lineSeparator());
		return result;
	}

	/**
	 * Method check file exist if not throws FileNotFoundException.
	 * 
	 * @param fileName
	 *            file name.
	 * @throws FileNotFoundException
	 *             if file not found.
	 */
	private static void exists(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getName());
		}
	}

	/**
	 * Method delete file.
	 * 
	 * @param nameFile
	 *            specified file name.
	 * @throws FileNotFoundException
	 */
	public static void delete(String nameFile) throws FileNotFoundException {
		exists(nameFile);
		new File(nameFile).delete();
	}

	/**
	 * Read file and returned the contents of the file as a string.
	 * 
	 * @param pathFile
	 *            path specific file.
	 * @param nameFile
	 *            name specific file.
	 * @return the contents of the file as a string.
	 */
	public static String getStringFromFile(String nameFile) {
		File f = new File(nameFile);

		StringBuilder sb = new StringBuilder();

		try {
			BufferedReader in = new BufferedReader(new FileReader(f.getAbsolutePath()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return sb.toString();
	}

}
