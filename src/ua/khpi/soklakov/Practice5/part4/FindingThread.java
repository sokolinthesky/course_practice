package ua.khpi.soklakov.Practice5.part4;

public class FindingThread extends Thread {
	
	private int numberOfString;
	private int[][] array;
	private int result;
	
	public int getResult() {
		return result;
	}

	public FindingThread(int numberOfString, int[][]array) {
		this.numberOfString = numberOfString;
		this.array = array;
	}
	
	public void run() {
		try {
			this.result = Part4.findMaxIntegerInArrayString(numberOfString, array);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
