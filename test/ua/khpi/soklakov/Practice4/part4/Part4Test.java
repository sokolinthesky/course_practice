package ua.khpi.soklakov.Practice4.part4;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;


import ua.khpi.soklakov.Practice4.ReaderFromFile;

public class Part4Test {
	
	@Test
	public void testIterator() throws IOException{
		String parseStr = ReaderFromFile.getStringFromFile(
				"src/", "part4.txt");
		
		Part4 p4 = new Part4(parseStr);
		
		String result = "";
		
		for(Object str : p4){
			result = result + str + "\n";
		}
		
		Assert.assertEquals(parseStr, result);
	}
	
	@Test
	public void testMain() throws IOException{
		Part4.main(new String[1]);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove(){
		@SuppressWarnings("rawtypes")
		Iterator itr = new Part4("abc \n").iterator();
		
		while(itr.hasNext()){
			itr.next();
			itr.remove();	
		}
	}
}
