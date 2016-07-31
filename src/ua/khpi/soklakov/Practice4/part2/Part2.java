package ua.khpi.soklakov.Practice4.part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Second task.
 * 
 * @author soklakov
 *
 */
public class Part2 {

	/**
	 * Metot creates a file fills it with random numbers, then creates another
	 * file and writes the sorted numbers.
	 * @return file contents
	 * @throws IOException
	 */
	public static String part2() throws IOException {
		String res = "";
		String sFileNameWithTenRandomNumbers = createFileWithTenRandomNumbers();
		String sReadingResult = rearFromTxtFile(sFileNameWithTenRandomNumbers);
		int[] aSortNumbers = getSortIntArrayOfStringResult(sReadingResult);
		String sNameFinalFile = writeIntArrayToFile(aSortNumbers);
		
		res = "input ==> " + sReadingResult + "\n" + "output ==> " + rearFromTxtFile(sNameFinalFile);
		
		return res;
	}

	/**
	 * Method creates txt file with random numbers.
	 * 
	 * @return file name.
	 * @throws IOException
	 */
	public static String createFileWithTenRandomNumbers() throws IOException {
		File file = new File("file1.txt");
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "cp1251"));
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			Integer j = r.nextInt(51);
			out.write(j.toString() + " ");
		}
		out.close();
		return file.getName();
	}

	/**
	 * Method reads txt file and return readind resoult in the type of string.
	 * 
	 * @return Readind resoult in the type of string.
	 * @throws IOException
	 */
	public static String rearFromTxtFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(
				 new InputStreamReader(new FileInputStream(fileName), "Cp1251"));
		int bite;
		String resultString = "";
		while ((bite = reader.read()) != -1) {
			Character c = (char) bite;
			resultString = resultString.concat(c.toString());
		}
		reader.close();

		return resultString;
	}

	/**
	 * Method converts string to int array, then array sorts.
	 * 
	 * @param resultString
	 *            specified string.
	 * @return Sorted array.
	 */
	public static int[] getSortIntArrayOfStringResult(String resultString) {
		String[] aSplipResoultString = resultString.split(" ");
		int[] aNumbers = new int[aSplipResoultString.length];
		for (int i = 0; i < aSplipResoultString.length; i++) {
			aNumbers[i] = Integer.parseInt(aSplipResoultString[i]);
		}

		aNumbers = sortArr(aNumbers);

		return aNumbers;
	}

	/**
	 * Method writes specified array to file and returns file name.
	 * 
	 * @param aNumbers
	 *            specified array.
	 * @throws IOException
	 */
	public static String writeIntArrayToFile(int[] aNumbers) throws IOException {
		File file = new File("file2.txt");
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "cp1251"));
		for (Integer i : aNumbers) {
			out.write(i.toString() + " ");
		}
		out.close();
		return file.getName();
	}

	/**
	 * Method sorts an array.
	 * 
	 * @param array
	 *            specified array
	 * @return sorted array
	 */
	public static int[] sortArr(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		return array;
	}
	
}
