package ua.khpi.soklakov.Practice4.part5;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

	/**
	 * Main method.
	 * 
	 * @param args 
	 */
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] split = input.split(" ");
		System.out.println(localization(split[0], split[1]));

		while (true) {
			input = in.nextLine();
			if (!input.equals("stop")) {
				String[] wSplit1 = input.split(" ");
				System.out.println(localization(wSplit1[0], wSplit1[1]));
			} else {
				break;
			}
		}
	}

	/**
	 * Method return translated key into selected language.
	 * 
	 * @param key
	 *            specified key.
	 * @param lang
	 *            specified language.
	 * @return translated key.
	 */
	public static String localization(String key, String lang) {
		Locale locale = new Locale(lang);
		ResourceBundle bundle = ResourceBundle.getBundle("resources", locale);

		return bundle.getString(key);
	}

}
