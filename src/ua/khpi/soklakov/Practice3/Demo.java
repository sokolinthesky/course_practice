package ua.khpi.soklakov.Practice3;

import java.security.NoSuchAlgorithmException;

import ua.khpi.soklakov.Practice3.part1.Part1;
import ua.khpi.soklakov.Practice3.part2.Part2;
import ua.khpi.soklakov.Practice3.part3.Part3;
import ua.khpi.soklakov.Practice3.part4.Part4;
import ua.khpi.soklakov.Practice3.part5.Part5;

public class Demo {
	
	public static String sInputPart1 = "ivanov;Ivan Ivanov;ivanov@mail.ru\n" + "petrov;Petr Petrov;petrov@google.com\n"
			+ "obama;Barack Obama;obama@google.com\n" + "bush;George Bush;bush@mail.ru\n";
	public static String sInputPart2 = "When I was younger, so much younger than today\n"
			+ "I never needed anybody's help in any way\n" + "But now these days are gone, I'm not so self-assured\n"
			+ "Now I find I've changed my mind" + "I've opened up the doors";
	public static String sInputPart3 = "When I was younger\n" + "I never needed";
	
	public static void main(String[] args) {
		System.out.println("===PART1===");
		Part1 part1 = new Part1(sInputPart1);
		System.out.println();
		System.out.println("");
		System.out.println(part1.convert1());
		System.out.println("");
		System.out.println(part1.convert2());
		System.out.println("");
		System.out.println(part1.convert3());
		System.out.println("");
		System.out.println(part1.convert4());
		System.out.println("===PART2===");
		System.out.println(Part2.convert(sInputPart2));
		System.out.println("");
		System.out.println("===PART3===");
		System.out.println(Part3.convert1(sInputPart3));
		System.out.println("");
		System.out.println("===PART4===");
		try {
			System.out.println(Part4.hash("123", "MD5"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("===PART5===");
		for(int i = 1; i <= 100; i++ ) {
			String roman = Part5.decimal2Roman(i);
			System.out.println(i + " ====> " + roman + " ====> " + Part5.roman2Decimal(roman));
		}
	}

}
