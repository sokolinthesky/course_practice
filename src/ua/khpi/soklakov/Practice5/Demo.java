package ua.khpi.soklakov.Practice5;

import java.io.IOException;

import ua.khpi.soklakov.Practice5.part1.Part1;
import ua.khpi.soklakov.Practice5.part2.Spam;
import ua.khpi.soklakov.Practice5.part3.Part3;
import ua.khpi.soklakov.Practice5.part4.Part4;
import ua.khpi.soklakov.Practice5.part5.Part5;
import ua.khpi.soklakov.Practice5.part6.Part6;

/**
 * Demo class.
 * 
 * @author O.Soklakov
 *
 */
public class Demo {

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		String line = "-----------------------";

		System.out.println(line + "Part1");
		Part1.main(args);
		Thread.sleep(5500);

		System.out.println(line + "Part3");
		Part3.main(args);
		Thread.sleep(1000);

		System.out.println(line + "Part4");
		Part4.main(args);
		Thread.sleep(1000);

		System.out.println(line + "Part5");
		Part5.main(args);
		Thread.sleep(1000);

		System.out.println(line + "Part6");
		Part6.main(args);
		Thread.sleep(1000);

		System.out.println(line + "Part2");
		Main.main(new String[] {});
		Spam.main(new String[] {});
	}

}