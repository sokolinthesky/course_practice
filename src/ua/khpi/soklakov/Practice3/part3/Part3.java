package ua.khpi.soklakov.Practice3.part3;

/**
 * subtask3
 * 
 * @author sokol
 *
 */
public class Part3 {

	/**
	 * Method changes the first letter of the word to uppercase.
	 * 
	 * @param input
	 *            string
	 * @return string with the words in which the first letter of the uppercase.
	 */
	public static String convert1(String input) {
		String sRes = "";
		String[] splitInput = input.split("\n");

		for (String s : splitInput) {
			String[] splitStr = s.split(" ");
			for (int i = 0; i < splitStr.length; i++) {
				splitStr[i] = firstUpperCase(splitStr[i].toLowerCase());
				sRes += splitStr[i] + " ";
			}
			sRes += "\n";
		}

		return sRes;
	}

	/**
	 * Method set first letter to upper case.
	 * 
	 * @param word
	 *            specified string.
	 * @return string with to begin with upper case letter.
	 */
	private static String firstUpperCase(String word) {
		if (word == null || word.isEmpty())
			return "";
		return word.substring(0, 1).toUpperCase() + word.substring(1);
	}

}
