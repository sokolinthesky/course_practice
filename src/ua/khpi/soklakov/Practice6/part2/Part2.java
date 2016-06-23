package ua.khpi.soklakov.Practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10000;
		int k = 2;
		List<Integer> aList = new ArrayList<>();
		List<Integer> lList = new LinkedList<>();
		fillList(n, aList);
		fillList(n, lList);

		long startTimeArrayList = System.currentTimeMillis();
		josephCircle(aList, k);
		long timeSpentArrayList = System.currentTimeMillis() - startTimeArrayList;
		System.out.println("ArrayList time - " + timeSpentArrayList);

		long startTimeLinkedList = System.currentTimeMillis();
		josephCircle(lList, k);
		long timeSpentLinked = System.currentTimeMillis() - startTimeLinkedList;
		System.out.println("LinkedList time - " + timeSpentLinked);
	}

	/**
	 * Method fills specified list.
	 * 
	 * @param n
	 *            list size.
	 * @param list
	 *            specified list.
	 */
	public static void fillList(int n, List<Integer> list) {
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}
	}

	/**
	 * People are standing in a circle waiting to be executed. Counting begins
	 * at a specified point in the circle and proceeds around the circle in a
	 * specified direction. After a specified number of people are skipped, the
	 * next person is executed. The procedure is repeated with the remaining
	 * people, starting with the next person, going in the same direction and
	 * skipping the same number of people, until only one person remains, and is
	 * freed.
	 * 
	 * @param list
	 *            specified list.
	 * @param k
	 *            specified number of people are skipped.
	 */
	public static void josephCircle(List<Integer> list, int k) {
		int count = 0;
		Iterator<Integer> it = list.iterator();
		while (list.size() > 1) {
			if (it.hasNext()) {
				it.next();
				count++;
				if (count == k) {
					it.remove();
					count = 0;
					// System.out.println(list);
				}
			} else {
				it = list.iterator();
			}
		}
	}

}
