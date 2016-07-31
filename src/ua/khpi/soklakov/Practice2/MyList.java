package ua.khpi.soklakov.Practice2;

/**
 * This interface represents common method for different Lists.
 * 
 * @author Soklakov
 *
 */
public interface MyList extends Iterable<Object> {

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param o
	 *            to add specified element.
	 */
	void add(Object o);

	/**
	 * Remove all elements from this list.
	 */
	void clear();

	/**
	 * Remove the first occurrence of the specified element form this list.
	 * 
	 * @param o
	 *            is the specified element to remove.
	 * @return true if the specified element removed.
	 */
	boolean remove(Object o);

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence.
	 * 
	 * @return Array contains all of the list.
	 */
	Object[] toArray();

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list.
	 */
	int size();

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param o
	 *            is specified element of list to contain.
	 * @return true if this list contains the specified element.
	 */
	boolean contains(Object o);

	/**
	 * Returns true if this list contains the specified list.
	 * 
	 * @param myList
	 *            is the specified collection to contain in list.
	 * @return true if this list contains the specified collection.
	 */
	boolean containsAll(MyList myList);
}
