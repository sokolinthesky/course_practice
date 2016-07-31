package ua.khpi.soklakov.Practice4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class read data from file.
 * 
 * @author Soklakov
 *
 */
public class ReaderFromFile {

	/**
	 * Read file and returned the contents of the file as a string.
	 * 
	 * @param pathFile
	 *            path specific file.
	 * @param nameFile
	 *            name specific file.
	 * @return the contents of the file as a string.
	 * @throws IOException 
	 */
	public static String getStringFromFile(String pathFile, String nameFile) throws IOException {
		File f = new File(pathFile, nameFile);

		StringBuilder sb = new StringBuilder();

		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(f.getAbsolutePath()), "Cp1251")); 

			String s;
			while ((s = in.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
			in.close();

		return sb.toString();
	}
}
