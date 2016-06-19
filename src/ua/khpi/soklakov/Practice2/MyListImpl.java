package ua.khpi.soklakov.Practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the <tt>MyList</tt> interface. Implements
 * all optional list operations, and permits all elements, including
 * <tt>null</tt>. In addition to implementing the <tt>List</tt> interface, this
 * class provides methods to manipulate the size of the array that is used
 * internally to store the list.
 * 
 * @author soklakov
 *
 */
public class MyListImpl implements MyList {

	private static final int DEFAULT_SIZE = 10;
	private Object[] array;
	private int size = 0;

	public MyListImpl() {
		array = new Object[DEFAULT_SIZE];
	}

	public MyListImpl(int size) {
		array = new Object[size];
	}

	/**
	 * appends the specified element to the end of this list
	 * 
	 * @param o
	 *            to add specified element.
	 */
	@Override
	public void add(Object e) {
		try {
			array[size] = e;
			size++;

		} catch (ArrayIndexOutOfBoundsException ex) {
			Object[] arr = array;
			array = new Object[array.length * 2];
			System.arraycopy(arr, 0, array, 0, arr.length);

			array[arr.length] = e;
			size++;

		}
	}

	/**
	 * removes all of the elements from this list
	 */
	@Override
	public void clear() {
		array = new Object[10];
		size = 0;

	}

	/**
	 * removes the first occurrence of the specified element from this list
	 * 
	 * @param o
	 *            is the specified element to remove
	 * 
	 * @return true if the specified element remove
	 */
	@Override
	public boolean remove(Object o) {
		int count = 0;
		int index = 0;

		try {
			for (int i = 0; i < size; i++) {
				if (array[i].equals(o))
					count++;
			}

			Object[] newArray = new Object[size - count];

			for (int i = 0; i < newArray.length + 1; i++) {
				if (array[i].equals(o)) {
					index++;
				} else {
					newArray[i - index] = array[i];
				}
			}

			this.array = newArray;
			size = size - count;

			return true;

		} catch (Exception ex) {
			ex.printStackTrace();

			return false;
		}
	}

	/**
	 * returns an array containing all of the elements in this list in proper
	 * sequence
	 */
	@Override
	public Object[] toArray() {
		return array.clone();
	}

	/**
	 * returns the number of elements in this list
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * returns true if this list contains the specified element.
	 * 
	 * @return true if the list contains the specidied element.
	 */
	@Override
	public boolean contains(Object o) {

		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(ua.khpi.soklakov.Practice2.MyList c) {
		boolean res = true;
		Object[] arr = c.toArray();

		for (int i = 0; i < c.size(); i++) {
			if (!this.contains(arr[i])) {
				res = false;
				break;
			}
		}
		return res;
	}

	/**
	 * Retuens the string with all elements of list
	 * 
	 * @return string with all elements of list
	 */
	@Override
	public String toString() {
		String string = "";

		for (int i = 0; i < array.length - 1; i++) {
			string += "[" + array[i] + "], ";
		}

		string += "[" + array[array.length - 1] + "]";
		return string;
	}

	/**
	 * MyList iterator over the elements in this list (in proper sequence).
	 * 
	 * @author soklakov
	 *
	 */
	private class IteratorImpl implements Iterator<Object> {
		private Object[] arr = array;
		private int count = 0;
		private int index = 0;
		private int removeCount = 0;

		/**
		 * Returns {@code true} if the iteration has more elements. (In other
		 * words, returns {@code true} if {@link #next} would return an element
		 * rather than throwing an exception.)
		 *
		 * @return {@code true} if the iteration has more elements
		 */
		public boolean hasNext() {
			if (count < size) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 */
		public Object next() {
			removeCount = 0;

			if (count == 0) {
				count++;
				return array[index];
			} else {
				count++;
				return array[count - 1];
			}

		}

		/**
		 * Removes from the underlying collection the last element returned by
		 * this iterator (optional operation).
		 *
		 * @throws IllegalStateException
		 *             if the {@code next} method has not yet been called, or
		 *             the {@code remove} method has already been called after
		 *             the last call to the {@code next} method
		 */
		public void remove() {
			if (count == 0 || removeCount > 0) {
				throw new IllegalStateException();
			} else {
				new MyListImpl().remove(array[count]);
				removeCount++;
			}
		}
	}

	/**
	 * Returns a MyList iterator over the elements in this list (in proper
	 * sequence).
	 */
	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

}
