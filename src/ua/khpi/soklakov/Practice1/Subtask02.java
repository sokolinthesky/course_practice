package ua.khpi.soklakov.Practice1;

/**
 * Second subtask
 * 
 * @author soklakov
 *
 */
public class Subtask02 {

	public static void main(String[] args) {
		System.out.println("sum: " + sum(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
	}

	/**
	 * Method return sum of two numbers.
	 * 
	 * @param dFirstNum
	 *            first number
	 * @param dSecondNum
	 *            second nuber
	 * @return sum of two numbers
	 */
	public static double sum(double dFirstNum, double dSecondNum) {
		return dFirstNum + dSecondNum;
	}

}
