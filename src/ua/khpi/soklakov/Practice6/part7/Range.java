package ua.khpi.soklakov.Practice6.part7;

import java.util.Iterator;

/**
 * Class represents range[n, m], where n - begin of range
 * and m - end of range.
 * 
 * @author JAVA__)
 *
 */
@SuppressWarnings("rawtypes")
public class Range implements Iterable{
	
	/**
	 * n - begin of range.
	 */
	private int n;
	
	/**
	 * m - end of range.
	 */
	private int m;
	
	/**
	 * Swap begin and end.
	 */
	private boolean reverse;
	
	/**
	 * Constructor class Range
	 * 
	 * @param n begin range.
	 * @param m end range.
	 * @param reverse swap n and m.
	 */
	public Range(int n, int m, boolean reverse){
		this.n = n;
		this.m = m;
		this.reverse = reverse;
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
	
	private class IteratorRange implements Iterator{
		private int begin;
		private int end;
		
		/**
		 * Constructor of IteratorRange.
		 */
		public IteratorRange(){
			if(reverse == true){
				begin = m + 1;
				end = n;
			}
			else{
				begin = n - 1;
				end = m;
			}
		}
		
		/**
		 * Returned true if next element exists.
		 * 
		 * @return true if next element exists.
		 */
		@Override
		public boolean hasNext() {
			if(reverse == true){
				return begin > end;
			}
			else{
				return begin < end;
			}
		}
		
		/**
		 * Returned next element.
		 */
		@Override
		public Object next() {
			if(reverse == true){
				begin--;
			}
			else{
				begin++;
			}
			
			return begin;
		}
	}
	
	/**
	 * main.
	 * 
	 * @param args //.
	 */
	public static void main(String[] args){
		Range range = new Range(3, 10, true);
		
		for(Object number : range){
			System.out.println(number);
		}
	}
}
