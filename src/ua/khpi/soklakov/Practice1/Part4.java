package ua.khpi.soklakov.Practice1;

/**
 * Fourth subtask
 * 
 * @author soklakov
 *
 */
public class Part4 {

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
		int number = num;

		while (number != 0) {
			// suming of digits
			sum = sum + (number % 10);
			number /= 10;
		}
		return sum;
	}
}
