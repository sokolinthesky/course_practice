package ua.khpi.soklakov.Practice5.part1;

public class Part1 {

	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		new Thread(new MySecondThread()).start();
	}

}
