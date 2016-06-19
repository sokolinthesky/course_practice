package ua.khpi.soklakov.Practice3.part1;

import java.util.HashSet;
import java.util.Set;

/**
 * Class contains methods for convertation strings.
 * 
 * @author soklakov.
 *
 */
public class Part1 {

	/**
	 * Method converts input string like "Login;Name;Email\n" to
	 * "name ==> email\n".
	 * 
	 * @param input
	 *            string of the form "Login;Name;Email\n".
	 * @return string of the form "name ==> email".
	 */
	public static String convert1(String input) {
		String sRes = "";
		String[] splitInput = input.split("\n");

		for (String s : splitInput) {
			String[] spl = s.split(";");
			sRes += spl[0] + " ==> " + spl[2] + "\n";
		}

		return sRes;
	}

	/**
	 * Method converts input string like "Login;Name;Email\n" to
	 * "name (email: email)\n".
	 * 
	 * @param input
	 *            string of the form "Login;Name;Email\n".
	 * @return string of the form "name (email: email)\n".
	 */
	public static String convert2(String input) {
		String sRes = "";
		String[] splitInput = input.split("\n");

		for (String s : splitInput) {
			String[] spl = s.split(";");
			sRes += spl[1] + " (email:  " + spl[2] + ")\n";
		}

		return sRes;
	}

	/**
	 * Grouping users by emails.
	 * 
	 * @param input
	 *            string of the form "Login;Name;Email\n".
	 * @return string of the form "email ==> user, ..., user\n.
	 */
	public static String convert3(String input) {
		String sRes = "";
		String[] splitInput = input.split("\n");
		Set<String> domenList = new HashSet<String>();

		for (String s : splitInput) {
			String[] split = s.split("@");
			domenList.add(split[1]);
		}

		for (String dom : domenList) {
			int count = 0;
			for (int i = 0; i < splitInput.length; i++) {

				if (splitInput[i].contains(dom)) {
					String[] spl = splitInput[i].split(";");

					if (count == 0) {
						count++;
						sRes += dom + " ==> " + spl[0];

					} else {
						sRes += ", " + spl[0];
					}
				}
			}
			sRes += "\n";
		}

		return sRes;

	}

	/**
	 * The password generation and output lines with a password.
	 * 
	 * @param input
	 *            string of the form "Login;Name;Email;\n".
	 * @return tring of the form "Login;Name;Email;Password\n".
	 */
	public static String convert4(String input) {
		String sRes = "";
		String[] splitInput = input.split("\n");

		for (int i = 0; i < splitInput.length; i++) {
			sRes += splitInput[i] + ";";

			for (int j = 0; j < 4; j++) {
				if (j == 3) {
					sRes += (int) (Math.random() * 10) + "\n";
				} else {
					sRes += (int) (Math.random() * 10);
				}
			}
		}

		return sRes;
	}

}
