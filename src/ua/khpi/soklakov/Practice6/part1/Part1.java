package ua.khpi.soklakov.Practice6.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Part1
 * 
 * @author O.Soklakov
 *
 */
public class Part1 {
	private static List<Word> words = new ArrayList<Word>();
	private static final String ENCODING = "Cp1251";

	/**
	 * Main method. Test.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in, ENCODING);
		String input = in.nextLine();
		System.out.println(Part1.getSortWords(input));
		in.close();
	}

	/**
	 * Method gets words from specified string.
	 * 
	 * @param input
	 *            specified string.
	 * @return result.
	 */
	public static String getSortWords(String input) {
		String[] aSplitInput = input.split(" ");
		String result = "";

		for (String str : aSplitInput) {
			Word word = new Word(str);
			if (!words.contains(word)) {
				words.add(word);

			} else {
				for (Iterator<Word> it = words.iterator(); it.hasNext();) {
					Word wr = it.next();
					if (wr.equals(word)) {
						wr.increm();
					}
				}
			}
		}
		Collections.sort(words, Word.getSnorderer());

		for (Word wr : words) {
			result = result.concat(wr + "\n");
		}

		return result;
	}

}
