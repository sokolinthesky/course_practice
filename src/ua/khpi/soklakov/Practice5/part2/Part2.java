package ua.khpi.soklakov.Practice5.part2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Part2 {
	
	/**
	 * Main method. 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String[] messages = {"spam1","spam2","spam3","spam4","spam5"};
		int[] intervals = {500,600,700,800,1000};
		
		// save standard input
		InputStream stdIn = System.in;
		// create input stream with line terminator (=ENTER)
		ByteArrayInputStream bais = new ByteArrayInputStream(System.lineSeparator().getBytes());
		// move internal pointer of input stream to the end of input
		bais.skip(System.lineSeparator().length());
		// assign new value of standard input
		System.setIn(bais);
		// main functionality
		new Spam(messages, intervals);
		Spam.main(args);
		// waith for 3 sec
		Thread.sleep(5000);
		System.out.println("Try to send enter to standard input");
		// move internal pointer to begin of input
		bais.reset();
		// restore standard input
		System.setIn(stdIn);
	}
}