package ua.khpi.soklakov.Practice6.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Part1 {
	private static List<Word> words = new ArrayList<Word>();

	public static String getWords(String input) {
		String[] splitInput = input.split(" ");
		String result = "";

		for (String str : splitInput) {
			Word word = new Word(str);
			if (!words.contains(word)) {
				words.add(word);

			} else {
				for (Iterator<Word> it = words.iterator(); it.hasNext();) {
					Word wr = it.next();
					if (wr.equals(word))
						wr.increm();
				}
			}
		}
		words.get(0);
		Collections.sort(words, Word.snorderer.reversed());

		for (Word wr : words) {
			result += wr + "\n";
		}

		return result;
	}

}
