package ua.khpi.soklakov.Practice4.part4;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.soklakov.Practice4.ReaderFromFile;

/**
 * Class implements interface Iterable and parse string and returned sentence
 * from string.
 * 
 * @author Soklakov
 *
 */
public class Part4 implements Iterable {

	/**
	 * The string will parse.
	 */
	private String sParse;

	public Part4(String parseString) {
		this.sParse = parseString;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String testTxt = ReaderFromFile.getStringFromFile("src/", "part4.txt");

		Part4 p4 = new Part4(testTxt);

		for (Object str : p4) {
			System.out.println(str);
		}
	}

	private class IteratorP4 implements Iterator {
		private Pattern pattern = Pattern.compile("[^\n]+");
		private Matcher matcher = pattern.matcher(sParse);

		@Override
		public boolean hasNext() {
			return matcher.find();
		}

		@Override
		public String next() {
			return sParse.substring(matcher.start(), matcher.end());
		}

		/**
		 * Removed last returned element.
		 * 
		 * @throws UnsupportedOperationException.
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Iterator iterator() {
		return new IteratorP4();
	}

}
