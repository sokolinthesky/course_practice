package ua.khpi.soklakov.Practice6.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The class parse text file by frequency, length and duplicates word.
 * 
 * @author Soklakov Oleg
 *
 */
public class Part6 {

	/**
	 * Main method.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Part6 part6 = new Part6();
		String[] splitInput = args[0].split(" ");
		String[] splitTask = args[1].split(" ");
		String filePath = splitInput[1];
		String method = splitTask[1];

		if (method.equals("frequency")) {
			System.out.println("===================> Part61 ");
			List<WordFreq> resultFreq = part6.frequency(filePath);
			StringBuilder resultWordFreq = new StringBuilder();
			for (WordFreq word : resultFreq) {
				resultWordFreq.append(
						word.getName().concat(" ==> ").concat(String.valueOf(word.getFrequency()).concat("\n")));
			}

			System.out.println(resultWordFreq.toString());

		} else if (method.equals("length")) {
			System.out.println("===================> Part62 ");
			List<WordLength> resultLength = part6.length(filePath);
			StringBuilder resultWordLength = new StringBuilder();
			for (WordLength word : resultLength) {
				resultWordLength
						.append(word.getName().concat(" ==> ").concat(String.valueOf(word.getLength()).concat("\n")));
			}

			System.out.println(resultWordLength.toString());

		} else if (method.equals("duplicates")) {
			System.out.println("===================> Part63 ");
			List<String> resultDuplicates = part6.duplicates((filePath));
			for (String s : resultDuplicates) {
				System.out.println(s);
			}
		}
	}

	/**
	 * Method returned the most frequency three word in the text.
	 * 
	 * @param pathFile
	 *            path to file.
	 * @return the most frequency word in the text.
	 */
	public List<WordFreq> frequency(String pathFile) {
		String sTextFile = ReaderFromFile.getStringFromFile(pathFile);
		List<WordFreq> lWords = new ArrayList<WordFreq>();
		List<String> lStringsTextFile = getString("([A-Za-z])+", sTextFile);

		for (String str : lStringsTextFile) {
			int freq = Collections.frequency(lStringsTextFile, str);

			lWords.add(new WordFreq(str, freq));
		}

		Set<WordFreq> sortWordsByFrequency = new TreeSet<WordFreq>(lWords);
		WordFreq[] wordFreq = new WordFreq[sortWordsByFrequency.size()];
		sortWordsByFrequency.toArray(wordFreq);
		List<WordFreq> lResult = lastWords(3, wordFreq);

		Collections.sort(lResult, new Comparator<WordFreq>() {

			@Override
			public int compare(WordFreq word1, WordFreq word2) {
				return word1.getName().compareToIgnoreCase(word2.getName());
			}

		});

		Collections.reverse(lResult);

		return lResult;
	}

	/**
	 * Method returned the biggest length three word in the text.
	 * 
	 * @param pathFile
	 *            path to file.
	 * @return the biggest length three word in the text.
	 */
	public List<WordLength> length(String pathFile) {
		String sTextFile = ReaderFromFile.getStringFromFile(pathFile);
		List<WordLength> lWords = new ArrayList<WordLength>();
		List<String> lStringsTextFile = getString("([A-Za-z])+", sTextFile);

		for (String str : lStringsTextFile) {
			lWords.add(new WordLength(str));
		}

		Set<WordLength> sortWordsByLength = new TreeSet<WordLength>(lWords);
		WordLength[] r = new WordLength[sortWordsByLength.size()];
		sortWordsByLength.toArray(r);
		List<WordLength> result = lastWords(3, r);
		Collections.reverse(result);

		return result;
	}

	/**
	 * Method returned first three word which have duplicates in the text.
	 * 
	 * @param pathFile
	 *            path to file.
	 * @return first three word which have duplicates in the text.
	 */
	public List<String> duplicates(String pathFile) {
		String sTextFile = ReaderFromFile.getStringFromFile(pathFile);
		List<String> lWordsDuplicates = new ArrayList<String>();
		List<String> lStringsTextFile = getString("([A-Za-z])+", sTextFile);
		int frequency = 0;

		for (String str : lStringsTextFile) {
			frequency = Collections.frequency(lStringsTextFile, str);
			if (frequency > 1 && !lWordsDuplicates.contains(str)) {
				lWordsDuplicates.add(str);
			}
		}

		Collections.reverse(lWordsDuplicates);
		String[] wordsDuplicatesArray = new String[lWordsDuplicates.size()];
		lWordsDuplicates.toArray(wordsDuplicatesArray);
		List<String> result = lastWords(3, wordsDuplicatesArray);
		result = inverseToUpperCase(result);

		return result;
	}

	/**
	 * Method returns list with upper case strings.
	 * 
	 * @param list
	 *            specified list.
	 * @return list with upper case strings.
	 */
	private List<String> inverseToUpperCase(List<String> list) {
		List<String> lResult = new ArrayList<>();

		for (String str : list) {
			lResult.add(reverse(str).toUpperCase());
		}

		return lResult;
	}

	private String reverse(String str) {
		int count = str.length();
		int iLength = str.length();
		StringBuilder sResult = new StringBuilder(iLength);

		for (count = (iLength - 1); count >= 0; count--) {
			sResult.append(str.charAt(count));
		}

		return sResult.toString();
	}

	private <T> List<T> lastWords(int n, T[] array) {
		List<T> lLastWords = new ArrayList<>();

		for (int i = array.length - n; i <= array.length - 1; i++) {
			T item = array[i];
			lLastWords.add(item);
		}

		return lLastWords;
	}

	/**
	 * Method return the String on regular expression.
	 * 
	 * @param regExp
	 *            regular expression on which parse string.
	 * @return The list of string on condition regular exp.
	 */
	private List<String> getString(String regExp, String stringToParse) {
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(stringToParse);
		List<String> lResult = new ArrayList<>();

		while (matcher.find()) {
			String str = stringToParse.substring(matcher.start(), matcher.end());
			lResult.add(str);
		}
		return lResult;
	}

}
