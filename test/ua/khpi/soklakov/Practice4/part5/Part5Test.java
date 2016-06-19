package ua.khpi.soklakov.Practice4.part5;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class Part5Test {
	
	private static final String ENCODING = "Cp1251";
	
	@Test
	public void testCreateNewPart5() {
		new Part5();
	}

	@Test
	public void testLocalization() {
		assertEquals("table", Part5.localization("table", "en"));
	}
	
	@Test
	public void testRunMainMethod() throws UnsupportedEncodingException {
		String[] arr = {};
		System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\nstop".getBytes(ENCODING)));
		Part5.main(arr);
	}

}
