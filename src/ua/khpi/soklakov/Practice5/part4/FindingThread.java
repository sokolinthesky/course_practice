package ua.khpi.soklakov.Practice5.part4;

/**
 * Thread finds max integer in array.
 * 
 * @author O.Soklakov
 *
 */
public class FindingThread extends Thread {

	private int numberOfString;
	private int[][] array;
	private int result;

	public int getResult() {
		return result;
	}

	public FindingThread(int numberOfString, int[][] array) {
		this.numberOfString = numberOfString;
		this.array = array.clone();
	}

	public void run() {
		try {
			this.result = Part4.findMaxIntegerInArrayString(numberOfString, array);
		} catch (InterruptedException e) {
			System.out.println("Exception in run");
		}
	}

}
