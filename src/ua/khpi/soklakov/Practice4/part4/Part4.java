package ua.khpi.soklakov.Practice4.part4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.khpi.soklakov.Practice4.ReaderFromFile;

/**
 * Class implements interface Iterable and parse string 
 * and returned sentence from string.
 * 
 * @author Eugene Jurkov
 *
 */
@SuppressWarnings("rawtypes")
public class Part4 implements Iterable {
	
	/**
	 * The string will parse.
	 */
	private String parseString;
	
	public Part4(String parseString){
		this.parseString = parseString;
	}
	
	private class IteratorPart4 implements Iterator{
		Pattern pattern = Pattern.compile("[^\n]+");
		Matcher matcher = pattern.matcher(parseString);	
		
		@Override
		public boolean hasNext() {
			return matcher.find();
		}

		@Override
		public String next() {
			return parseString.substring(matcher.start(), 
					matcher.end());
		}
		
		/**
		 * Removed last returned element.
		 * 
		 * @throws UnsupportedOperationException.
		 */
		@Override
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public Iterator iterator() {
		return new IteratorPart4();
	}
	
	/**
	 * Test main.
	 * 
	 * @param args test.
	 */
	public static void main(String[] args){
		String testTxt = ReaderFromFile.getStringFromFile("src/", "part4.txt");
		
		Part4 p4 = new Part4(testTxt);
		
		for(Object str : p4){
			System.out.println(str);
		}
	}
}
