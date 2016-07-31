package ua.khpi.soklakov.Practice4.part3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.junit.Assert;
import org.junit.Test;



public class Part3Test {

	@Test
	public void testGetData() {
		Part3 p3 = new Part3("a bcd 43.43 432 � � ���� 89 .98");
		
		Assert.assertEquals("432 89 ", p3.getData("int"));
		
		Assert.assertEquals("43.43 .98 ", p3.getData("double"));
		
		Assert.assertEquals("a � � ", p3.getData("char"));
		
		Assert.assertEquals("bcd ���� ", p3.getData("String"));
		
		Assert.assertEquals("", p3.getData("abc"));	
	}
	
	@Test
	public void testMain() throws IOException{
		System.setIn(new
				ByteArrayInputStream("char\nString\nint\ndouble\n".getBytes("Cp1251")));
		Part3.main(new String[1]);
		System.setIn(System.in);
	}
}
