package ua.khpi.soklakov.Practice3.part2;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Subtask2.
 * 
 * @author Soklakov Oleg
 *
 */
public class Part2 {

	/**
	 * The method returns words which have maximum and minimum letters in the
	 * word.
	 * 
	 * @param input
	 *            specified string
	 * @return words which have maximum and minimum letters in the word.
	 */
	public static String convert(String input) {
		String sResult = "";
		String sMaxWords = "Max: ";
		String sMinWords = "Min: ";
		int minSize = 1;
		int maxSize = 1;
		String[] aSplitInput = input.split("\n");
		Set<String> setMinWords = new HashSet<String>();
		Set<String> setMaxWords = new HashSet<String>();
		List<String> lWords = new ArrayList<String>();

		for (int i = 0; i < aSplitInput.length; i++) {
			String[] splip = aSplitInput[i].split(" ");
			for (String s : splip) {
				if (s.contains("'")) {
					String[] aStr = s.split("'");
					lWords.add(aStr[0]);
					lWords.add(aStr[1]);

				} else if (s.contains("-")) {
					String[] aStr = s.split("-");
					lWords.add(aStr[0]);
					lWords.add(aStr[1]);

				} else if (s.contains(",")) {
					String[] aStr = s.split(",");
					for (String sStr : aStr) {
						if (!sStr.equals("")) {
							lWords.add(sStr);
						}
					}
				} else {
					lWords.add(s);
				}
			}
		}

		for (String s : lWords) {
			if (s.length() > maxSize) {
				maxSize = s.length();
			}
		}

		for (int i = 0; i < lWords.size(); i++) {
			if (lWords.get(i).length() == minSize) {
				setMinWords.add(lWords.get(i));
			}
		}

		for (String s : setMinWords) {
			if (s.length() == minSize) {
				sMinWords = sMinWords.concat(s + ", ");
			}
		}

		for (int i = 0; i < lWords.size(); i++) {
			if (lWords.get(i).length() == maxSize) {
				setMaxWords.add(lWords.get(i));
			}
		}

		for (String s : setMaxWords) {
			if (s.length() == maxSize) {
				sMaxWords = sMaxWords.concat(s + ", ");
			}
		}
		sResult = sResult.concat(
				sMinWords.substring(0, sMinWords.length() - 1) + "\n" + sMaxWords.substring(0, sMaxWords.length() - 1));

		return sResult;
	}

}
