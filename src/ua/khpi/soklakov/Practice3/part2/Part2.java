package ua.khpi.soklakov.Practice3.part2;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Subtask2.
 * 
 * @author soklakov
 *
 */
public class Part2 {

	/**
	 * Method returns words which have maximum and minimum letters in the word.
	 * 
	 * @param input
	 *            string
	 * @return words wich have maximum and minimum letters in the word.
	 */
	public static String convert(String input) {
		String sRes = "";
		String maxWords = "Max: ";
		String minWords = "Min: ";
		String[] splitInput = input.split("\n");
		List<String> listWords = new ArrayList<String>();
		Set<String> minWordsList = new HashSet<String>();
		Set<String> maxWordsList = new HashSet<String>();

		int minSize = 1;
		int maxSize = 1;

		for (int i = 0; i < splitInput.length; i++) {
			String[] spl = splitInput[i].split(" ");
			for (String s : spl) {
				if (s.contains("'")) {
					String[] aStr = s.split("'");
					listWords.add(aStr[0]);
					listWords.add(aStr[1]);

				} else if (s.contains("-")) {
					String[] aStr = s.split("-");
					listWords.add(aStr[0]);
					listWords.add(aStr[1]);

				} else if (s.contains(",")) {
					String[] aStr = s.split(",");
					for (String sStr : aStr) {
						if (sStr.equals("")) {
						} else {
							listWords.add(sStr);
						}
					}
				} else {
					listWords.add(s);
				}
			}
		}

		for (String s : listWords) {
			if (s.length() > maxSize) {
				maxSize = s.length();
			}
		}

		for (int i = 0; i < listWords.size(); i++) {
			if (listWords.get(i).length() == minSize) {
				minWordsList.add(listWords.get(i));
			}
		}

		for (String s : minWordsList) {
			if (s.length() == minSize) {
				minWords += s + ", ";
			}
		}

		for (int i = 0; i < listWords.size(); i++) {
			if (listWords.get(i).length() == maxSize) {
				maxWordsList.add(listWords.get(i));
			}
		}

		for (String s : maxWordsList) {
			if (s.length() == maxSize) {
				maxWords += s + ", ";
			}
		}
		sRes += minWords.substring(0, minWords.length() - 1) + "\n" + maxWords.substring(0, maxWords.length() - 1);

		return sRes;
	}

}
