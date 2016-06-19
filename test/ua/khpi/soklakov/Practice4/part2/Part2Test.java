package ua.khpi.soklakov.Practice4.part2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import ua.khpi.soklakov.Practice4.part2.Part2;

public class Part2Test {

	@Test
	public void testCreateFileWithTenRandomNumbers() throws IOException {
		assertEquals("file1.txt", Part2.createFileWithTenRandomNumbers());
	}

	@Test
	public void testRearFromTxtFile() throws IOException {
		assertNotNull(Part2.rearFromTxtFile("file1.txt"));
	}

	@Test
	public void testSortArray() {
		int[] aInts = new int[] { 2, 3, 1 };
		assertEquals(aInts[0], Part2.sortArr(aInts)[1]);
	}

	@Test
	public void testWriteToFile() throws IOException {
		int[] aInts = new int[] { 2, 3, 1 };
		Part2.writeIntArrayToFile(aInts);
		assertTrue(new File(Part2.writeIntArrayToFile(aInts)).length() != 0);
	}

	@Test
	public void testGetSortIntArrayOfStringResult() {
		int[] aInts = new int[] { 1, 2, 3 };
		String str = "2 3 1";
		assertArrayEquals(aInts, Part2.getSortIntArrayOfStringResult(str));
	}
	
	@Test
	public void testPart2() throws IOException {
		Part2.part2();
	}
	
	@Test
	public void testCreateClass() {
		new Part2();
	}

}
