package ua.khpi.soklakov.Practice2;

import java.util.Iterator;

/**
 * This interface represents common method for different Lists.
 * 
 * @author Eugene Jurkov
 *
 */
public interface ListIterator extends Iterator<Object> {
	
	/**
	 * Returns true if this list iterator has more elements when traversing the list in
  	 * the reverse direction.
	 * 
	 * @return true if returns true if this list iterator has more elements when traversing the list in
     * the reverse direction
	 */
    boolean hasPrevious(); 
    
    /**
     * returns the previous element in the list and moves the cursor position backwards.
     * 
     * @return the previous element in the list.
     */
    Object previous(); 
    
    /**
     * replaces the last element returned by next or previous with the specified element
     * 
     * @param e specific element which will replace.
     */
    void set(Object e); 
    
    /**
     * Removes from the list the last element that was returned by next or previous.
     */
    void remove(); 
}
