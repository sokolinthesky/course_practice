package ua.khpi.soklakov.Practice1;

/**
 * Fifth subtask
 * 
 * @author soklakov
 *
 */
public class Part5 {

	public static void main(String[] args) {
		// int digit1 = Integer.parseInt(args[0]);
		// String char1 = String.valueOf(args[1]);
		// String char2 = String.valueOf(args[2]);
		System.out.println(args[1] + " > " + Part5.columnToNumber(args[1]));
		System.out.println(Integer.parseInt(args[0]) + " > " + Part5.numberToColumn(Integer.parseInt(args[0])));
		System.out.println(args[2] + " > " + Part5.rightColumn(args[2]));
	}

	/**
	 * Method return number of column
	 * 
	 * @param column
	 *            column name
	 * @return column number
	 */
	public static int columnToNumber(String column) {
		int digit = 0;

		/*
		 * В одной итерации вычисляется номер одного символа колонки, с учетом
		 * порядка в exel документе и суммируется с предыдущим результатом.
		 */
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
	public static String numberToColumn(int number) {
		String chars = ""; /* Найденые символы */
		String charsMirror = ""; /* Символы в правильном порядке */
		int modul;
		int divident = number;
		
		/*
		 * Нахождение номера символа в exel документе, далее перевод этого
		 * номера, в номер ASCII таблицы и сохранение. В каждой итерации
		 * происходит уменьшение исходного номера колонки с учетом найденой
		 * буквы.
		 */
		while (divident != 0) {
			modul = divident % 26;
			if (modul == 0) {
				chars += "Z";
				divident = (divident - 1) / 26;
			} else {
				chars += (char) (modul + 64);
				divident = (divident - modul) / 26;
			}
		}

		/* Получение правильного порядка символов в имени колонки */
		for (int i = 0; i < chars.length(); i++)
			charsMirror += chars.charAt(chars.length() - i - 1);
		return charsMirror;

	}

	/**
	 * Method return next column name.
	 * 
	 * @param column
	 *            column name
	 * @return
	 */
	public static String rightColumn(String column) {
		String chars = "";
		int num;
		num = columnToNumber(column);
		num++;
		chars = numberToColumn(num);
		return chars;
	}

}
