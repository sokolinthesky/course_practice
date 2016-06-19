package ua.khpi.soklakov.Practice1;

/**
 * Fourth subtask
 * 
 * @author soklakov
 *
 */
public class Subtask04 {

	public static void main(String[] args) {
		System.out.println("sum of digits: " + sumOfDigits(Integer.parseInt(args[0])));
	}

	/**
	 * Method return sum of digits of positiv integer
	 * 
	 * @param num
	 *            positive integer
	 * @return sum of digits
	 */
	public static int sumOfDigits(int num) {
		int sum = 0;

		while (num != 0) {
			// suming of digits
			sum = sum + (num % 10);
			num /= 10;
		}
		return sum;
	}
}
