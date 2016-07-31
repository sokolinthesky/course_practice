package ua.khpi.soklakov.Practice3.part5;

/**
 * Part5
 * 
 * @author O.Soklakov
 *
 */
public class Part5 {

	private static final int DECIMAL_M = 1000;
	private static final int DECIMAL_D = 500;
	private static final int DECIMAL_C = 100;
	private static final int DECIMAL_L = 50;
	private static final int DECIMAL_X = 10;
	private static final int DECIMAL_V = 5;
	private static final int DECIMAL_I = 1;
	
	private static final int ROMAN_100 = 100;
	private static final int ROMAN_90 = 90;
	private static final int ROMAN_50 = 50;
	private static final int ROMAN_40 = 40;
	private static final int ROMAN_10 = 10;
	private static final int ROMAN_9 = 9;
	private static final int ROMAN_5 = 5;
	private static final int ROMAN_4 = 4;
	private static final int ROMAN_1 = 1;

	/**
	 * Method converts decimal number to Roman number.
	 * 
	 * @param decimal
	 *            decimal number.
	 * @return Roman number.
	 */
	public static String toRoman(int x) {
		int iDecimal = x;
		String sResult = "";

		// 100
		while (iDecimal >= 100) {
			sResult = sResult.concat("C");
			iDecimal = iDecimal - ROMAN_100;
		}

		// 90
		while (iDecimal >= 90) {
			sResult = sResult.concat("XC");
			iDecimal = iDecimal - ROMAN_90;
		}

		// 50
		while (iDecimal >= 50) {
			sResult = sResult.concat("L");
			iDecimal = iDecimal - ROMAN_50;
		}

		// 40
		while (iDecimal >= 40) {
			sResult = sResult.concat("XL");
			iDecimal = iDecimal - ROMAN_40;
		}

		// 10
		while (iDecimal >= 10) {
			sResult = sResult.concat("X");
			iDecimal = iDecimal - ROMAN_10;
		}

		// 9
		while (iDecimal >= 9) {
			sResult = sResult.concat("IX");
			iDecimal = iDecimal - ROMAN_9;
		}

		// 5
		while (iDecimal >= 5) {
			sResult = sResult.concat("V");
			iDecimal = iDecimal - ROMAN_5;
		}

		// 9
		while (iDecimal >= 4) {
			sResult = sResult.concat("IV");
			iDecimal = iDecimal - ROMAN_4;
		}

		// 1
		while (iDecimal >= 1) {
			sResult = sResult.concat("I");
			iDecimal = iDecimal - ROMAN_1;
		}

		return sResult;
	}

	/**
	 * Method converts Roman number to decimal.
	 * 
	 * @param s
	 *            Roman number.
	 * @return decimal number.
	 */
	public static int toDecimal(String s) {
		String sRomanNum = s.toUpperCase();
		int sLastNum = 0;
		int iDec = 0;
		/*
		 * operation to be performed on upper cases even if user enters roman
		 * values in lower case chars
		 */
		for (int x = sRomanNum.length() - 1; x >= 0; x--) {
			char convertToDecimal = sRomanNum.charAt(x);

			switch (convertToDecimal) {
			case 'M':
				iDec = processDecimal(1000, sLastNum, iDec);
				sLastNum = DECIMAL_M;
				break;

			case 'D':
				iDec = processDecimal(500, sLastNum, iDec);
				sLastNum = DECIMAL_D;
				break;

			case 'C':
				iDec = processDecimal(100, sLastNum, iDec);
				sLastNum = DECIMAL_C;
				break;

			case 'L':
				iDec = processDecimal(50, sLastNum, iDec);
				sLastNum = DECIMAL_L;
				break;

			case 'X':
				iDec = processDecimal(10, sLastNum, iDec);
				sLastNum = DECIMAL_X;
				break;

			case 'V':
				iDec = processDecimal(5, sLastNum, iDec);
				sLastNum = DECIMAL_V;
				break;

			case 'I':
				iDec = processDecimal(1, sLastNum, iDec);
				sLastNum = DECIMAL_I;
				break;
			default:
				break;
			}
		}
		return iDec;
	}

	/**
	 * Process decimal.
	 * 
	 * @param dec
	 *            specified decimal.
	 * @param lastNum
	 *            specified last number.
	 * @param lastDec
	 *            specified last decimal.
	 * @return
	 */
	public static int processDecimal(int dec, int lastNum, int lastDec) {
		if (lastNum > dec) {
			return lastDec - dec;
		} else {
			return lastDec + dec;
		}
	}

}
