package ua.khpi.soklakov.Practice5.part4;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		int[][] array = Part4.getArrayWithCustomSizeAndRandomNumbers(4, 100, 100);
		try {
			long startTime = System.currentTimeMillis();
			int resWithThreads = Part4.findMaxIntegersByThreads(array);
			long timeSpent = System.currentTimeMillis() - startTime;
			System.out.println("Threds finds max value for in " + timeSpent);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long startTime2 = System.currentTimeMillis();
		int resWithoutThreads = Part4.findMaxInteger(array);
		long timeSpent2 = System.currentTimeMillis() - startTime2;
		System.out.println("Without threds - " + timeSpent2);
	}

}
