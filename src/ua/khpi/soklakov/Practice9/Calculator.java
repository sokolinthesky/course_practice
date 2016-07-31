package ua.khpi.soklakov.Practice9;

/**
 * Calculator.
 * 
 * @author O.Soklakov
 *
 */
public class Calculator {

	/**
	 * Calculate.
	 * 
	 * @param x
	 *            specified number one.
	 * @param y
	 *            specified number two.
	 * @param operaton
	 *            type of opretion.
	 * @return result operation.
	 */
	public static int calc(int x, int y, String operaton) {
		if (operaton.equals("+")) {
			return x + y;
		}
		if (operaton.equals("-")) {
			return x - y;
		}
		return 0;
	}

}
