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
	 * The string which will parse.
	 */
	private String sToParse;

	/**
	 * Constructor which initialized string for parse.
	 * 
	 * @param stringToParse
	 *            string to parse.
	 */
	public Part1(String stringToParse) {
		this.sToParse = stringToParse;
	}

	/**
	 * This method parse String in form ivanov ==> ivanov@mail.ru.
	 * 
	 * @return the string in ivanov ==> ivanov@mail.ru.
	 */
	public String convert1() {
		String sResult = "";
		List<String> lEmails = parceAndGetString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		for (String sEmail : lEmails) {
			String email = sEmail;
			String[] split = email.split("@");
			String sSurname = split[0];
			sResult = sResult.concat(sSurname + " ==> " + email + "\n");
		}
		return sResult;
	}

	/**
	 * This method parse String of the form Ivanov Ivan (email: ivanov@mail.ru).
	 * 
	 * @return The String of form (email: ivanov@mail.ru).
	 */
	public String convert2() {
		String sResult = "";
		List<String> lNames = parceAndgetNames();
		List<String> lEmails = parceAndGetString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		for (int i = 0; i <= lNames.size() - 1; i++) {
			sResult = sResult.concat(lNames.get(i) + " (email: " + lEmails.get(i) + ")\n");
		}
		return sResult;
	}

	/**
	 * The method parse String of the form ivanov;Ivan
	 * Ivanov;ivanov@mail.ru;2344. Split the string on "\n".
	 * 
	 * @return string like 'ivanov;Ivan Ivanov;ivanov@mail.ru;2344'.
	 */
	public String convert3() {
		String sResult = "";
		Map<String, String> namesAndDomens = getDomensAndNames();

		for (Map.Entry<String, String> entry : namesAndDomens.entrySet()) {
			String value = entry.getValue();
			sResult = sResult.concat(value + "\n");
		}

		return sResult;

	}

	/**
	 * This method parse String in String of the form ivanov;Ivan
	 * Ivanov;ivanov@mail.ru;2344.
	 * 
	 * @return string like 'ivanov;Ivan Ivanov;ivanov@mail.ru;2344'.
	 */
	public String convert4() {
		String[] aValue = sToParse.split("\n");
		String sResult = "";

		for (String s : aValue) {
			sResult = sResult.concat(s + ";" + randomGenerator() + "\n");
		}

		return sResult;
	}

	/**
	 * This method returned String of generated the four digit number.
	 * 
	 * @return String of generated the four digit number.
	 */
	private String randomGenerator() {
		String sResult = "";

		for (int i = 0; i <= 3; i++) {
			Integer intRandom = new Random().nextInt(9);
			sResult = sResult.concat(intRandom.toString());
		}

		return sResult;
	}

	/**
	 * Get the String on regular expression.
	 * 
	 * @param regExp
	 *            regular expression on which parse string.
	 * @return The list of string on condition regular exp.
	 */
	private List<String> parceAndGetString(String regExp) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(sToParse);
		List<String> lResult = new ArrayList<>();

		while (matcher.find()) {
			String str = sToParse.substring(matcher.start(), matcher.end());
			lResult.add(str);
		}
		return lResult;
	}

	/**
	 * Get string in form 'Ivan Ivanov' with help reg exp.
	 * 
	 * @return The list of string of form Ivan Ivanov
	 */
	private List<String> parceAndgetNames() {
		Pattern pattern = Pattern.compile("([A-Z][a-z]{1,}[\\s]*)");
		Matcher matcher = pattern.matcher(sToParse);
		List<String> lResult = new ArrayList<>();

		while (matcher.find()) {
			String sFirstName = sToParse.substring(matcher.start(), matcher.end());
			String sSurname = "";
			if (matcher.find()) {
				sSurname = sToParse.substring(matcher.start(), matcher.end());
				lResult.add(sFirstName + " " + sSurname);
			}
		}
		return lResult;
	}

	/**
	 * The method returned map contain domens and names.
	 * 
	 * @return This method returned domens and names in Map.
	 */
	private Map<String, String> getDomensAndNames() {
		List<String> lEmails = parceAndGetString("([\\w-\\.]+)@" + "((?:[\\w]+\\.)+)([a-zA-Z]{2,4})");

		Map<String, String> mNamesAndDomens = new HashMap<>();

		for (int i = 0; i <= lEmails.size() - 1; i++) {
			String sEmail = lEmails.get(i);
			String[] aNameAndDomen = sEmail.split("@");
			String sName = aNameAndDomen[0];
			String sDomen = aNameAndDomen[1];

			if (!mNamesAndDomens.containsKey(sDomen)) {
				mNamesAndDomens.put(sDomen, sDomen + " ==> " + sName);
			} else {
				String sOldValue = mNamesAndDomens.get(sDomen);
				String sNewValue = sOldValue.concat(", ").concat(sName);
				mNamesAndDomens.put(sDomen, sNewValue);
			}
		}

		return mNamesAndDomens;
	}

}
