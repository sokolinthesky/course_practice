package ua.khpi.soklakov.Practice5.part1;

/**
 * Part1
 * 
 * @author O.Soklakov
 *
 */
public class Part1 {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		new Thread(new MySecondThread()).start();
	}

}
