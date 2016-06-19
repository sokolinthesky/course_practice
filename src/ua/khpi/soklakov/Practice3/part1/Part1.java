package ua.khpi.soklakov.Practice3.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class contains methods for convertation strings.
 * 
 * @author soklakov.
 *
 */
public class Part1 {

	/**
	 * The string which will convert.
	 */
	private String stringToParse;

	/**
	 * Constructor which initialized string for parse.
	 * 
	 * @param stringToParse
	 *            string to parse.
	 */
	public Part1(String stringToParse) {
		this.stringToParse = stringToParse;
	}

	/**
	 * This method convert Parse String in String of the form ivanov ==>
	 * ivanov@mail.ru. At first with help regExp get all emails. Split each
	 * email by name and domen. Join them.
	 * 
	 * @return the string in ivanov ==> ivanov@mail.ru.
	 */
	public String convert1() {
		String result = "";

		List<String> emails = getString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		for (String e : emails) {
			String email = e;
			String[] str = email.split("@");

			String surname = str[0];

			result = result + surname + " ==> " + email + "\n";
		}
		return result;
	}

	/**
	 * This method convert Parse String in String of the form Ivanov Ivan
	 * (email: ivanov@mail.ru). At first with help regExp get all First and Last
	 * names and get all emails. Join them.
	 * 
	 * @return The String of form (email: ivanov@mail.ru).
	 */
	public String convert2() {
		String result = "";

		List<String> names = getNames();
		List<String> emails = getString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		for (int i = 0; i <= names.size() - 1; i++) {
			result = result + names.get(i) + " (email: " + emails.get(i) + ")\n";
		}
		return result;
	}

	/**
	 * This method convert Parse String in String of the form ivanov;Ivan
	 * Ivanov;ivanov@mail.ru;2344. Split the string on "\n". Join to them random
	 * password. Join them all.
	 * 
	 * @return string like 'ivanov;Ivan Ivanov;ivanov@mail.ru;2344'.
	 */
	public String convert3() {
		String result = "";

		Map<String, String> namesAndDomens = getDomensAndNames();

		for (Map.Entry<String, String> entry : namesAndDomens.entrySet()) {
			String value = entry.getValue();

			result = result + value + "\n";
		}

		return result;

	}

	/**
	 * This method convert Parse String in String of the form ivanov;Ivan
	 * Ivanov;ivanov@mail.ru;2344. Split the string on "\n". Join to them random
	 * password. Join them all.
	 * 
	 * @return string like 'ivanov;Ivan Ivanov;ivanov@mail.ru;2344'.
	 */
	public String convert4() {
		String[] value = stringToParse.split("\n");
		String result = "";

		for (String s : value) {
			result = result + s + ";" + randomGenerator() + "\n";
		}

		return result;
	}

	/**
	 * Get the String on regular expression.
	 * 
	 * @param regExp
	 *            regular expression on which parse string.
	 * @return The list of string on condition regular exp.
	 */
	private List<String> getString(String regExp) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(stringToParse);

		List<String> result = new ArrayList<>();

		while (matcher.find()) {
			String str = stringToParse.substring(matcher.start(), matcher.end());
			result.add(str);
		}
		return result;
	}

	/**
	 * Get string in form Ivan Ivanov with help reg exp.
	 * 
	 * @return The list of string of form Ivan Ivanov
	 */
	private List<String> getNames() {
		Pattern pattern = Pattern.compile("([A-Z][a-z]{1,}[\\s]*)");
		Matcher matcher = pattern.matcher(stringToParse);

		List<String> result = new ArrayList<>();

		while (matcher.find()) {
			String firstName = stringToParse.substring(matcher.start(), matcher.end());
			String surname = "";
			if (matcher.find()) {
				surname = stringToParse.substring(matcher.start(), matcher.end());
				result.add(new String(firstName + " " + surname));
			}
		}
		return result;
	}

	/**
	 * This method returned domens and names in Map. Where domens is key and
	 * names is value of domens.
	 * 
	 * @return This method returned domens and names in Map.
	 */
	private Map<String, String> getDomensAndNames() {
		List<String> emails = getString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		Map<String, String> namesAndDomens = new HashMap<>();

		for (int i = 0; i <= emails.size() - 1; i++) {
			String email = emails.get(i);
			String[] nameAndDomen = email.split("@");
			String name = nameAndDomen[0];
			String domen = nameAndDomen[1];

			if (!namesAndDomens.containsKey(domen)) {
				namesAndDomens.put(domen, domen + " ==> " + name);
			} else {
				String oldValue = namesAndDomens.get(domen);
				namesAndDomens.replace(domen, oldValue, oldValue + ", " + name);
			}
		}

		return namesAndDomens;
	}

	/**
	 * This method returned String of generated the four digit number.
	 * 
	 * @return String of generated the four digit number.
	 */
	private String randomGenerator() {
		Random random = new Random();

		String result = "";

		for (int i = 0; i <= 3; i++) {
			result = result + random.nextInt(9);
		}

		return result;
	}

}
