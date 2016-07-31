package ua.khpi.soklakov.Practice5.part6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Part6 {

	private File file = new File("part6.txt");
	private static RandomAccessFile raf;
	private int pointer = 0;

	/**
	 * Delete file if exist.
	 */
	public void checkFile() {
		if (file != null) {
			try {
				delete(this.file.getName());
			} catch (FileNotFoundException e) {
				System.out.println("Exception in constructor part6");
			}
		} else {
			this.file = new File("part6.txt");
		}
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Part6 part6 = new Part6();
		part6.checkFile();
		Part6.raf = new RandomAccessFile(part6.file, "rw");
		MyThread[] threads = new MyThread[10];

		for (int i = 0; i <= 9; i++) {
			Integer number = i;
			MyThread thread = new MyThread(number.toString(), part6.pointer);
			threads[i] = thread;
			thread.start();
			part6.pointer += 21;
		}

		for (MyThread th : threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}

		raf.close();

		System.out.println(getStringFromFile(part6.file.getName()));
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
			raf.write(string.getBytes("cp1251"));
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
	public static boolean delete(String nameFile) throws FileNotFoundException {
		exists(nameFile);
		return new File(nameFile).delete();
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

		StringBuilder strBuil = new StringBuilder();

		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(f.getAbsolutePath()), "Cp1251"));
			try {
				String st;
				while ((st = bufferedReader.readLine()) != null) {
					strBuil.append(st);
					strBuil.append("\n");
				}
			} finally {
				bufferedReader.close();
			}
		} catch (IOException e) {
			System.out.println("IOException in getStringFromFile");
		}

		return strBuil.toString();
	}

}
