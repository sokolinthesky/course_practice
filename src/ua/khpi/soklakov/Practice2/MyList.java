package ua.khpi.soklakov.Practice2;

public interface MyList extends Iterable<Object> {

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param e
	 *            specified element.
	 */
	void add(Object e);

	/**
	 * Removes all of the elements from this list.
	 */
	void clear();

	/**
	 * Removes the first occurrence of the specified element from this list.
	 * 
	 * @param o
	 *            specified element.
	 * @return true if the specified element remove.
	 */
	boolean remove(Object o);

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 * 
	 * @return an array containing all of the elements in this list.
	 */
	Object[] toArray();

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return number of elements.
	 */
	int size();

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param o
	 *            specified element.
	 * @return true if this list contains the specified element.
	 */
	boolean contains(Object o);

	/**
	 * returns true if this list contains all of the elements of the specified
	 * list
	 * 
	 * @param c
	 *            specified list
	 * @return true if this list contains all of the elements of the specified
	 *         list
	 */
	boolean containsAll(MyList c);

}
