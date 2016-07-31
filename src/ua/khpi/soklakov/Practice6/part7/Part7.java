package ua.khpi.soklakov.Practice6.part7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class represents range[n, m].
 * 
 * @author Oleg Soklakov
 *
 */
public class Part7 implements Iterable {

	/**
	 * n - begin of range.
	 */
	private int iBegin;

	/**
	 * m - end of range.
	 */
	private int iEnd;

	/**
	 * Swap begin and end.
	 */
	private boolean reverse;

	/**
	 * Constructor class Range
	 * 
	 * @param n
	 *            begin range.
	 * @param m
	 *            end range.
	 * @param reverse
	 *            swap n and m.
	 */
	public Part7(int n, int m, boolean reverse) {
		this.iBegin = n;
		this.iEnd = m;
		this.reverse = reverse;
	}

	/**
	 * Main method. Test.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Part7 range = new Part7(3, 10, true);

		for (Object number : range) {
			System.out.print(number + " ");
		}
	}

	/**
	 * Returned Iterator for Range.
	 * 
	 * @return Iterator for Range.
	 */
	@Override
	public Iterator iterator() {
		return new IteratorRange();
	}

	private class IteratorRange implements Iterator {
		private Integer begin;
		private int end;

		/**
		 * Returned next element.
		 */
		@Override
		public Object next() {
			if (begin == null) {
				throw new NoSuchElementException();
			}

			if (reverse) {
				begin--;
			} else {
				begin++;
			}

			return begin;
		}

		public void remove() {
			throw new UnsupportedOperationException("remove");
		}

		/**
		 * Returned true if next element exists.
		 * 
		 * @return true if next element exists.
		 */
		@Override
		public boolean hasNext() {
			if (reverse) {
				return begin > end;
			} else {
				return begin < end;
			}
		}

		/**
		 * Constructor of IteratorRange.
		 */
		public IteratorRange() {
			if (reverse) {
				begin = iEnd + 1;
				end = iBegin;
			} else {
				begin = iBegin - 1;
				end = iEnd;
			}
		}

	}

}
