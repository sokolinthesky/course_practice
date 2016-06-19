package ua.khpi.soklakov.Practice4;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import ua.khpi.soklakov.Practice4.part2.Part2;
import ua.khpi.soklakov.Practice4.part5.Part5;

public class Demo {
	
	private static final String ENCODING = "Cp1251";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("=========================== PART2");
		try {
			System.out.println(Part2.part2());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("=========================== PART5");
		System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\nstop".getBytes(ENCODING)));
		Part5.main(args);
	}

}
