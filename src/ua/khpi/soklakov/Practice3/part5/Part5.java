package ua.khpi.soklakov.Practice3.part5;

public class Part5 {

	public static void main(String[] args) {
		System.out.println(decimal2Roman(99));
		System.out.println(roman2Decimal("XCIX"));
		System.out.println(roman2Decimal("XCIX"));
	}

	/**
	 * Method converts decimal number to Roman number.
	 * 
	 * @param x
	 *            decimal number.
	 * @return Roman number.
	 */
	public static String decimal2Roman(int x) {
		String result = "";

		// 100
		while (x >= 100) {
			result += "C";
			x -= 100;
		}

		// 90
		while (x >= 90) {
			result += "XC";
			x -= 90;
		}

		// 50
		while (x >= 50) {
			result += "L";
			x -= 50;
		}

		// 40
		while (x >= 40) {
			result += "XL";
			x -= 40;
		}

		// 10
		while (x >= 10) {
			result += "X";
			x -= 10;
		}

		// 9
		while (x >= 9) {
			result += "IX";
			x -= 9;
		}

		// 5
		while (x >= 5) {
			result += "V";
			x -= 5;
		}

		// 9
		while (x >= 4) {
			result += "IV";
			x -= 4;
		}

		// 1
		while (x >= 1) {
			result += "I";
			x -= 1;
		}

		return result;
	}

	/**
	 * Method converts Roman number to decimal.
	 * 
	 * @param s
	 *            Roman number.
	 * @return decimal number.
	 */
	public static int roman2Decimal(String s) {
		int decimal = 0;
		int lastNumber = 0;
		String romanNumeral = s.toUpperCase();
		/*
		 * operation to be performed on upper cases even if user enters roman
		 * values in lower case chars
		 */
		for (int x = romanNumeral.length() - 1; x >= 0; x--) {
			char convertToDecimal = romanNumeral.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				decimal = processDecimal(1000, lastNumber, decimal);
				lastNumber = 1000;
				break;

			case 'D':
				decimal = processDecimal(500, lastNumber, decimal);
				lastNumber = 500;
				break;

			case 'C':
				decimal = processDecimal(100, lastNumber, decimal);
				lastNumber = 100;
				break;

			case 'L':
				decimal = processDecimal(50, lastNumber, decimal);
				lastNumber = 50;
				break;

			case 'X':
				decimal = processDecimal(10, lastNumber, decimal);
				lastNumber = 10;
				break;

			case 'V':
				decimal = processDecimal(5, lastNumber, decimal);
				lastNumber = 5;
				break;

			case 'I':
				decimal = processDecimal(1, lastNumber, decimal);
				lastNumber = 1;
				break;
			}
		}
		return decimal;
	}

	public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
		if (lastNumber > decimal) {
			return lastDecimal - decimal;
		} else {
			return lastDecimal + decimal;
		}
	}

}
