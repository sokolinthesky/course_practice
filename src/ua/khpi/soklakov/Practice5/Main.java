package ua.khpi.soklakov.Practice5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import ua.khpi.soklakov.Practice5.part2.*;

public class Main {
	
	/**
	 * Press enter.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
        // save standard input
        InputStream inputStream = System.in;
 
        // create input stream with line terminator (=ENTER)
        ByteArrayInputStream byteArrayInStr = new ByteArrayInputStream(System.lineSeparator().getBytes(Charset.forName("UTF-8")));
 
        // move internal pointer of input stream to the end of input
        byteArrayInStr.skip(System.lineSeparator().length()); 
 
        // assign new value of standard input   
        System.setIn(byteArrayInStr);
         
        // main functionality
        Spam.main(args);
 
        // waith for 3 sec
        Thread.sleep(5000);
 
        // move internal pointer to begin of input
        byteArrayInStr.reset();
 
        // restore standard input
        System.setIn(inputStream);
    }
}
