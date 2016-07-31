package ua.khpi.soklakov.Practice4.part3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.soklakov.Practice4.ReaderFromFile;

/**
 * The class show how types are contain in string. Part3.
 * 
 * @author Soklakov Oleg
 *
 */
public class Part3 {

	private static final String ENCODING = "Cp1251";
	
	/**
	 * The string types will be searched in.
	 */
	private String sParse;

	/**
	 * Constructor with initialization parse string.
	 * 
	 * @param str
	 *            The string types will be searched in.
	 */
	public Part3(String str) {
		sParse = str;
	}

	/**
	 * Main method. Test.
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws IOException {
		String sTestTxt = ReaderFromFile.getStringFromFile("src/", "part3.txt");
		Part3 p3 = new Part3(sTestTxt);
		Scanner scan = new Scanner(System.in, ENCODING);

		String sType = "";
		for (int i = 0; i < 4; i++) {
			sType = scan.nextLine();
			System.out.println(p3.getData(sType));
		}
		scan.close();
	}

	/**
	 * The method finds type which the user enters.
	 * 
	 * @param type
	 *            specified type of date.
	 * @return string of data.
	 */
	public String getData(String type) {
		if (type.equals("int")) {
			return getInt();
		} else if (type.equals("double")) {
			return getDouble();
		} else if (type.equals("char")) {
			return getChar();
		} else if (type.equals("String")) {
			return getString();
		} else {
			return "";
		}
	}

	/**
	 * Returned value whose type represents int.
	 * 
	 * @return value whose type represents int.
	 */
	private String getInt() {
		String sResult = "";
		List<String> lTypeNumber = getString("(?:\\d*\\.)?\\d+");

		for (String number : lTypeNumber) {
			if (!number.contains(".")) {
				sResult = sResult.concat(number + " ");
			}
		}

		return sResult;
	}

	/**
	 * Method returned value whose type represents Double.
	 * 
	 * @return value whose type represents Double.
	 */
	private String getDouble() {
		String result = "";
		List<String> typeNumber = getString("(?:\\d*\\.)?\\d+");

		for (String number : typeNumber) {
			if (number.contains(".")) {
				result = result.concat(number + " ");
			}
		}

		return result;
	}

	/**
	 * Method returned value whose type represents char.
	 * 
	 * @return value whose type represents char.
	 */
	private String getChar() {
		String result = "";

		List<String> typeString = getString("[^0-9.\\s]+");

		for (String str : typeString) {
			if (str.length() < 2) {
				result = result.concat(str + " ");
			}
		}

		return result;
	}

	/**
	 * Method returned value whose type represents String.
	 * 
	 * @return value whose type represents String.
	 */
	private String getString() {
		String sResult = "";
		List<String> lTypeString = getString("[^0-9.\\s]+");

		for (String str : lTypeString) {
			if (str.length() > 1) {
				sResult = sResult.concat(str + " ");
			}
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
	public List<String> getString(String regExp) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(sParse);
		List<String> lResult = new ArrayList<>();

		while (matcher.find()) {
			String str = sParse.substring(matcher.start(), matcher.end());
			lResult.add(str);
		}
		return lResult;
	}

}
