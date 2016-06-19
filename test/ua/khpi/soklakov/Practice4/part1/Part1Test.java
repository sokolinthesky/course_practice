package ua.khpi.soklakov.Practice4.part1;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

	@Test
	public void testToUpperCaseWords() {
		Part1 p1 = new Part1("abc");
		Assert.assertEquals("abc ", p1.toUpperCaseWords());
		
		Part1 p2 = new Part1("abcd");
		Assert.assertEquals("ABCD ", p2.toUpperCaseWords());
	}
	
	@Test
	public void testMain(){
		Part1.main(new String[1]);
	}
}
