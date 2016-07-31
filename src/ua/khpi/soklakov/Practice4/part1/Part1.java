package ua.khpi.soklakov.Practice4.part1;

import java.io.IOException;

import ua.khpi.soklakov.Practice4.ReaderFromFile;

/**
 * Class converts a string from a file.
 * 
 * @author Soklakov Oleg
 *
 */
public class Part1 {

	/**
	 * String which store strings read from file.
	 */
	private String sFromFile;

	/**
	 * Constructor this class which create file and read strings from file write
	 * to stringFromFile.
	 * 
	 * @param pathFile
	 *            to file.
	 * @param nameFile
	 *            name of file.
	 */
	public Part1(String specifiedString) {
		sFromFile = specifiedString;
	}

	/**
	 * Main method. Test.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String sTestStringFromTxt = ReaderFromFile.getStringFromFile("src/", "part1.txt");
		Part1 part1 = new Part1(sTestStringFromTxt);
		System.out.println(part1.toUpperCase());
	}
	
	/**
	 * This method upper case words if length of words more 3. At first it split
	 * String. Iterate by array of String and validate length of String. If
	 * condition true add to result string with in upper case. Else add to
	 * result string without changes.
	 * 
	 * @return String sorted by condition.
	 */
	public String toUpperCase() {
		String[] aWords = sFromFile.split(" ");
		String sResult = "";

		for (String word : aWords) {
			if (word.length() >= 4) {
				word = word.toUpperCase();
				sResult = sResult.concat(word + " ");
			} else {
				sResult = sResult.concat(word + " ");
			}
		}
		return sResult;
	}

}
