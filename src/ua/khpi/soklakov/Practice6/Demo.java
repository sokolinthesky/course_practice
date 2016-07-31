package ua.khpi.soklakov.Practice6;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import ua.khpi.soklakov.Practice6.part1.Part1;
import ua.khpi.soklakov.Practice6.part2.Part2;
import ua.khpi.soklakov.Practice6.part3.Part3;
import ua.khpi.soklakov.Practice6.part4.Part4;
import ua.khpi.soklakov.Practice6.part5.Part5;
import ua.khpi.soklakov.Practice6.part6.Part6;
import ua.khpi.soklakov.Practice6.part7.Part7;

/**
 * Test class.
 * 
 * @author Oleg Soklakov.
 *
 */
public class Demo {
	private static final String ENCODING = "Cp1251";
 
	/**
	 * Main method.
	 * 
	 * @param args
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {

		System.out.println("~~~~~~~~~~~~Part1");
		System.setIn(new ByteArrayInputStream("asd asdf asd asdf asdf 43 asdsf 43 43 434".getBytes(ENCODING)));
		Part1.main(args);

		System.out.println("~~~~~~~~~~~~Part2");
		Part2.main(args);

		System.out.println("~~~~~~~~~~~~Part3");
		Part3.main(args);
		
		System.out.println("~~~~~~~~~~~~Part4");
		Part4.main(args);

		System.out.println("~~~~~~~~~~~~Part5");
		Part5.main(args);

		System.out.println("~~~~~~~~~~~~Part6");
		Part6.main(new String[]{"-i src/text.txt", "-t frequency"});
		Part6.main(new String[]{"-i src/text.txt", "-t length"});
		Part6.main(new String[]{"-i src/text.txt", "-t duplicates"});

		System.out.println("~~~~~~~~~~~~Part7");
		Part7.main(args);
	}
}
