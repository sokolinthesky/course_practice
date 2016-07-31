package ua.khpi.soklakov.Practice3.part4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {

	private static final String ENCODING = "Cp1251";
	
	/**
	 * Method generates password hash.
	 * 
	 * @param hashStr
	 *            specified password.
	 * @param algoritmName
	 *            algorithm type.
	 * @return hash in byte array.
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	private static byte[] hyteArray(String hashStr, String algoritmName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance(algoritmName);
		digest.update(hashStr.getBytes(ENCODING));
		return digest.digest();
	}

	/**
	 * Method returns password hash.
	 * 
	 * @param hashStr
	 *            specified password.
	 * @param algoritmName
	 *            algorithm type.
	 * @return hash.
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException 
	 */
	public static String hash(String hashStr, String algoritmName) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = "";
		byte[] hash = hyteArray(hashStr, algoritmName);

		for (byte b : hash) {
			result = result.concat(parseNumberToHex(b));
		}

		return result.toUpperCase();
	}

	/**
	 * Method returns byte hexadecimal representation.
	 * 
	 * @param b
	 *            specified byte.
	 * @return byte hexadecimal representation.
	 */
	private static String parseNumberToHex(byte b) {
		String result = "";
		String binary = Integer.toBinaryString(b);

		if (b < 0) {
			String rightBinaryString = binary.substring(24, binary.length());
			String str1 = rightBinaryString.substring(0, 4);
			String str2 = rightBinaryString.substring(4, rightBinaryString.length());
			String hexstr = Integer.toString(Integer.parseInt(str1, 2), 16);
			String hexstr2 = Integer.toString(Integer.parseInt(str2, 2), 16);

			result = result.concat(hexstr + hexstr2);

		} else {
			result = Integer.toString(Integer.parseInt(binary, 2), 16);
		}

		return result;
	}
}
