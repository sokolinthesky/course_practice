package ua.khpi.soklakov.Practice5.part6;

import java.io.IOException;

public class MyThread extends Thread {
	
	private String number;
	private int pointer;
	
	public MyThread(String number, int pointer) {
		this.number = number;
		this.pointer = pointer;
	}
	
	public void run() {
		try {
			Part6.writeToFile(pointer, Part6.generateString(number));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
