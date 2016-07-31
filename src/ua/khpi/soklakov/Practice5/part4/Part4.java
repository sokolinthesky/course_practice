package ua.khpi.soklakov.Practice5.part4;

/**
 * Part4.
 * 
 * @author O.Soklakov
 *
 */
public class Part4 {

	/**
	 * Main method. Test.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		int[][] array = Part4.getArrayWithCustomSizeAndRandomNumbers(4, 100, 100);
		try {
			long startTime = System.currentTimeMillis();
			Part4.findMaxIntegersByThreads(array);
			long timeSpent = System.currentTimeMillis() - startTime;
			System.out.println("Threds - " + timeSpent);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in main");
		}

		long startTime2 = System.currentTimeMillis();
		Part4.findMaxInteger(array);
		long timeSpent2 = System.currentTimeMillis() - startTime2;
		System.out.println("Without threds - " + timeSpent2);

	}

	/**
	 * Method create matrix with random numbers and have specified dimensions.
	 * 
	 * @param width
	 *            matrix width.
	 * @param hight
	 *            matrix height.
	 * @param toNumber
	 *            random range.
	 * @return
	 */
	public static int[][] getArrayWithCustomSizeAndRandomNumbers(int width, int hight, int toNumber) {
		int[][] array = new int[width][hight];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * (toNumber + 1));
			}
		}
		return array;

	}

	/**
	 * Method return maximum of the array.
	 * 
	 * @param numberOfString
	 *            number of string.
	 * @param array
	 *            array an array in which the search for.
	 * @return maximum number.
	 * @throws InterruptedException
	 */
	public static int findMaxIntegerInArrayString(int numberOfString, int[][] array) throws InterruptedException {
		int max = array[0][0];
		for (int i = 0; i < array[numberOfString].length; i++) {
			Thread.sleep(1);
			if (array[numberOfString][i] > max) {
				max = array[numberOfString][i];
			}
		}
		return max;
	}

	/**
	 * Method return maximum integer of array.
	 * 
	 * @param array
	 *            specified array.
	 * @return maximum integer.
	 */
	public static int getMaxInt(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * Finding maximum integer of array with threads.
	 * 
	 * @param array
	 *            specified array.
	 * @return maximum integer.
	 * @throws InterruptedException
	 */
	public static int findMaxIntegersByThreads(int[][] array) throws InterruptedException {
		int[] findedMaxNumbers = new int[array.length];
		FindingThread[] threads = new FindingThread[array.length];
		for (int i = 0; i < array.length; i++) {
			threads[i] = new FindingThread(i, array);
			threads[i].start();
		}
		for (int i = 0; i < array.length; i++) {
			threads[i].join();
		}
		for (int i = 0; i < findedMaxNumbers.length; i++) {
			findedMaxNumbers[i] = threads[i].getResult();
		}

		return Part4.getMaxInt(findedMaxNumbers);
	}

	/**
	 * Finding maximum integer of array without threads.
	 * 
	 * @param array
	 *            specified array.
	 * @return maximum integer.
	 * @throws InterruptedException
	 */
	public static int findMaxInteger(int[][] array) throws InterruptedException {
		int[] findedMaxNumbers = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			findedMaxNumbers[i] = findMaxIntegerInArrayString(i, array);
		}

		return Part4.getMaxInt(findedMaxNumbers);
	}

}
