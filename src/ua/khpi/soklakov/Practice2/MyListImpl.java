package ua.khpi.soklakov.Practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the MyList interface.
 * 
 * @author Soklakov Oleg
 */
public class MyListImpl implements MyList, ListIterable {

	/**
	 * Reference to first node.
	 */
	private Node headList;

	/**
	 * Reference to last node.
	 */
	private Node tailList;

	/**
	 * The number of elements of list.
	 */
	private int size;

	/**
	 * Default constructor of empty list.
	 */
	public MyListImpl() {
		headList = null;
		tailList = null;
		size = 0;
	}

	/**
	 * Inner static class represents node of the list.
	 * 
	 */
	private static class Node {

		/**
		 * Reference to the previous node of the list.
		 */
		private Node previous;

		/**
		 * Reference to the next node of the list.
		 */
		private Node next;

		/**
		 * Content of the node.
		 */
		private Object item;

		public Node(Node prev, Object object, Node next) {
			this.previous = prev;
			item = object;
			this.next = next;
		}
	}

	/**
	 * This method removes all the elements of this list.
	 */
	@Override
	public void clear() {
		headList = null;
		tailList = null;
		size = 0;
	}

	/**
	 * This method add the specified element to the end List.
	 * 
	 * @param specified
	 *            oject.
	 */
	@Override
	public void add(Object object) {
		Node tailListOld = tailList;
		Node tailListNew = new Node(tailListOld, object, null);

		if (tailListOld == null) {
			tailList = tailListNew;
			headList = tailList;
		} else {
			tailListOld.next = tailListNew;
			tailList = tailListNew;
		}

		size++;
	}

	/**
	 * Return true if the element removed form list
	 * 
	 * @return true if the element removed from list
	 */
	@Override
	public boolean remove(Object object) {

		if (object == null) {
			return false;
		}

		for (Node n = headList; n != null; n = n.next) {
			if (object.equals(n.item)) {
				Node prevN = n.previous;
				Node nextX = n.next;

				if (prevN == null) {
					headList = nextX;
				} else {
					prevN.next = n.next;
				}

				if (nextX == null) {
					tailList = prevN;
				} else {
					nextX.previous = prevN;
				}

				size--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Method returns array contains all elements of the list.
	 * 
	 * @return array contains all elements of the list.
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		int i = 0;

		for (Node n = headList; n != null; n = n.next) {
			array[i] = n.item;
			i++;
		}

		return array;
	}

	/**
	 * Returns size, the number of elements of list.
	 * 
	 * @return the number of elements of list.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Method returned true if the specified element contains in list.
	 * 
	 * @param object
	 *            is the specified element which will be checked.
	 * @return true if the specified element contains in list.
	 */
	@Override
	public boolean contains(Object object) {
		for (Node n = headList; n != null; n = n.next) {
			if (object.equals(n.item)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Method returns true if this list contains the specified list.
	 * 
	 * @param myList
	 *            is the specified collection to contain in list.
	 * @return true if this list contains the specified collection.
	 */
	@Override
	public boolean containsAll(MyList myList) {
		Object[] array = toArray();
		int count = 0;

		for (Node n = headList; n != null; n = n.next) {
			for (Object object : array) {
				if (n.item.equals(object)) {
					count++;
				}
			}
		}

		if (count < array.length) {
			return false;
		}

		return true;
	}

	/**
	 * Returns the string with all elements of list
	 * 
	 * @return the string with all elements of list.
	 */
	@Override
	public String toString() {
		String result = "";
		for (Node n = headList; n != null; n = n.next) {
			result = result.concat("[" + n.item + "],");
		}

		result = result.concat("{" + result + "}");
		return result;
	}

	/**
	 * This class implements Iterator Interface.
	 */
	private class IteratorImpl implements Iterator<Object> {

		/**
		 * Reference to the next element after last returned.
		 */
		private Node next;

		/**
		 * Last returned element by Iterator.
		 */
		private Node lastReturned;

		/**
		 * Index of the last returned element.
		 */
		private int index;

		/**
		 * Constructor of the Iterator.
		 */
		public IteratorImpl() {
			next = headList;
			index = 0;
		}

		/**
		 * Returned true if there is next element.
		 * 
		 * @return true if there is next element.
		 */
		@Override
		public boolean hasNext() {
			return index < size;
		}

		/**
		 * Method returns the next element in the iteration.
		 * 
		 * @return the next element in the iteration.
		 */
		@Override
		public Object next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			lastReturned = next;
			next = next.next;
			index++;
			return lastReturned.item;
		}

		/**
		 * Method removes from the underlying collection the last element returned by
		 * this iterator.
		 */
		@Override
		public void remove() {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}

			Node previousLastReturned = lastReturned.previous;

			if (previousLastReturned == null) {
				headList = next;
			} else {
				previousLastReturned.next = next;
			}

			if (lastReturned.next == null) {
				tailList = previousLastReturned;
			} else {
				lastReturned.next.previous = previousLastReturned;
			}

			lastReturned = null;

			index--;
			size--;
		}
	}

	/**
	 * Method returned the iterator of this list.
	 * 
	 * @return the iterator of this list.
	 */
	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	/**
	 * This class implements ListIterator Interface.
	 */
	private class ListIteratorImpl extends IteratorImpl implements ListIterator {

		/**
		 * Last returned element by Iterator.
		 */
		private Node lastReturned;

		/**
		 * Reference to the next element after last returned.
		 * 
		 */
		private Node next;
		private int nextIndex;

		/**
		 * Constructor of List Iterator where next index = size.
		 */
		ListIteratorImpl() {
			nextIndex = size;
		}

		/**
		 * returned true if previous element exists.
		 * 
		 * @return true if previous element exists.
		 */
		@Override
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		/**
		 * Returned previous element moves the cursor position backwards.
		 * 
		 * @return previous element.
		 */
		@Override
		public Object previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}

			lastReturned = next = (next == null) ? tailList : next.previous;
			nextIndex--;
			return lastReturned.item;
		}

		/**
		 * Replaces the last element returned by next or previous with the
		 * specified element.
		 * 
		 * @param specific
		 *            element which will replace.
		 */
		@Override
		public void set(Object e) {
			if (lastReturned == null) {
				throw new IllegalStateException();
			}

			lastReturned.item = e;
		}

	}

	/**
	 * Returned the list iterator of this list.
	 * 
	 * @return the iterator of this list.
	 */
	@Override
	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

}
