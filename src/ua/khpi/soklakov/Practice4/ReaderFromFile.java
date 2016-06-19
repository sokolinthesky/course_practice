package ua.khpi.soklakov.Practice4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class read data from file.
 * 
 * @author Eugene Jurkov
 *
 */
public class ReaderFromFile {
	
	/**
	 * Read file and returned the contents of the file as a string. 
	 * 
	 * @param pathFile path specific file.
	 * @param nameFile name specific file.
	 * @return the contents of the file as a string.
	 */
	public static String getStringFromFile(String pathFile,
										String nameFile){
		File f = new File(pathFile, nameFile);
		
		 StringBuilder sb = new StringBuilder();
		 
		 try {
			 BufferedReader in = new BufferedReader(new FileReader( f.getAbsolutePath()));
		        try {
		            String s;
		            while ((s = in.readLine()) != null) {
		                sb.append(s);
		                sb.append("\n");
		            }
		        } finally {
		            in.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
		 
	return sb.toString();
	}
}
