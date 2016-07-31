package ua.khpi.soklakov.Practice4.part1;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testToUpperCaseWords() {
		Part1 p1 = new Part1("abc");
		Assert.assertEquals("abc ", p1.toUpperCase());
		
		Part1 p2 = new Part1("abcd");
		Assert.assertEquals("ABCD ", p2.toUpperCase());
	}
	
	@Test
	public void testMain() throws IOException{
		Part1.main(new String[1]);
	}
}
