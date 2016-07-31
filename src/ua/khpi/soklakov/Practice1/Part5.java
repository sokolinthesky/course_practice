package ua.khpi.soklakov.Practice1;

/**
 * Fifth subtask
 * 
 * @author Soklakov
 *
 */
public class Part5 {

	/**
	 * Main method.
	 * Test all.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(args[1] + " ===> " + Part5.column2Number(args[1]));
		System.out.println(Integer.parseInt(args[0]) + " > " + Part5.number2Column(Integer.parseInt(args[0])));
		System.out.println(args[2] + " ===> " + Part5.rightColumn(args[2]));
	}

	/**
	 * Method return number of column
	 * 
	 * @param column
	 *            column name
	 * @return column number
	 */
	public static int column2Number(String column) {
		int digit = 0;

		for (int i = column.length(); i > 0; i--) {
			digit += (int) (column.charAt(column.length() - i) - 64) * Math.pow(26, column.length() - i);
		}
		return digit;
	}

	/**
	 * Method return name of column
	 * 
	 * @param number
	 *            column number
	 * @return column name
	 */
	public static String number2Column(int number) {
		String allChars = ""; 
		String result = ""; 
		int mod;
		int div = number;
		
		while (div != 0) {
			mod = div % 26;
			if (mod == 0) {
				allChars = allChars.concat("Z");
				div = (div - 1) / 26;
			} else {
				allChars += (char) (mod + 64);
				div = (div - mod) / 26;
			}
		}

		for (int i = 0; i < allChars.length(); i++) {
			Character c = allChars.charAt(allChars.length() - i - 1);
			result = result.concat(c.toString());
		}
		return result;

	}

	/**
	 * Method return next column name.
	 * 
	 * @param column
	 *            column name
	 * @return
	 */
	public static String rightColumn(String column) {
		String result = "";
		int num;
		num = column2Number(column);
		num++;
		result = number2Column(num);
		return result;
	}

}
