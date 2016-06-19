package ua.khpi.soklakov.Practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implementation of the MyList interface.
 * @author Eugene Jurkov
 * @version 1.0
 */
public class MyListImpl implements MyList, ListIterable{
	
	/**
	 * Reference to first node.
	 */
	private Node headList;
	
	/**
	 * Reference to last node.
	 */
	private Node tailList;
	
	/**
	 * Number of elements of list.
	 */
	private int size;
	
	/**
	 * Constructor of empty list.
	 */
	public MyListImpl(){
		headList = null;
		tailList = null;
		size = 0;
	}
	
	/**
	 * This inner class represents node of the list.
	 * 
	 */
	private class Node{
		
		/**
		 * Reference to the next node of the list.
		 */
		Node next;
		
		/**
		 * Reference to the previous node of the list.
		 */
		Node prev;
		
		/**
		 * Content of the node.
		 */
		Object item;
		
		public Node(Node prev ,Object object, Node next){
			this.prev = prev;
			item = object;
			this.next = next;
		}
	}
	
	/**
	 * This method appends the specified element to the end List.
	 * 
	 * @param object which will be add
	 */
	@Override
	public void add(Object object) {
		Node oldTailList = tailList;
		Node newTailList = new Node(oldTailList ,object, null);
		
		if(oldTailList == null){
			tailList = newTailList;
			headList = tailList;
		}
		else{
			oldTailList.next = newTailList;
			tailList = newTailList;
		}
		
		size++;
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
	 * Return true if the element removed form list 
	 * 
	 * @return true if the element removed from list
	 */
	@Override
	public boolean remove(Object object) {
		
		if(object == null)
			return false;
		
		for(Node x = headList; x != null; x = x.next){
			if(object.equals(x.item)){
				Node prevX = x.prev;
				Node nextX = x.next;
				
				if(prevX == null){
					headList = nextX;
				}
				else{
					prevX.next = x.next;
				}
				
				if(nextX == null){
					tailList = prevX;
				}
				else{
					nextX.prev = prevX;
				}
				
				size--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returned array contains all elements of the list.
	 * 
	 * @return array contains all elements of the list.
	 */
	@Override
	public Object[] toArray() {
		Object[] arrayElementsOfList = new Object[size];
		int i = 0;
		
		for(Node x = headList; x != null; x = x.next){
			arrayElementsOfList[i] = x.item;
			i++;
		}
		
		return arrayElementsOfList;
	}
	
	/**
	 * Returns the number of elements of list.
	 * 
	 * @return the number of elements of list.
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Returned true if the specified element contains in list.
	 * 
	 * @param object is the specified element which will be checked. 
	 * @return true if the specified element contains in list.
	 */
	@Override
	public boolean contains(Object object) {
		for(Node x = headList; x != null; x = x.next){
			if(object.equals(x.item))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if this list contains the specified list.
	 * 
	 * @param myList is the specified collection to contain in list.
	 * @return true if this list contains the specified collection.
	 */
	@Override
	public boolean containsAll(MyList myList) {
		int count = 0;
		Object[] arrayMyList = toArray();
		
		for(Node x = headList; x != null; x = x.next){
			for(Object objectMyList : arrayMyList){
				if(x.item.equals(objectMyList)){
					count++;
				}
			}
		}
		
		if(count < arrayMyList.length)
			return false;
		
		return true;
	}
	
	/**
	 * Returns the string with all elements of list
	 * 
	 * @return the string with all elements of list.
	 */
	@Override
	public String toString(){
		String resultStr = "";
		for(Node x = headList; x != null; x = x.next){
			resultStr = resultStr + "[" + x.item + "],";
		}
		
		resultStr = "{" + resultStr + "}";
		return resultStr;
	}
	
	/**
	 * This class implements Iterator Interface.
	 */
	private class IteratorImpl implements Iterator<Object>{
		
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
		int index;
		
		/**
		 * Constructor of the Iterator.
		 */
		public IteratorImpl(){
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
		 * Returns the next element in the iteration. 
		 *  
		 * @return the next element in the iteration.
		 */
		@Override
		public Object next() {
			if(!hasNext())
				throw new NoSuchElementException();
			
			lastReturned = next;
			next = next.next;
			index++;
			return lastReturned.item;
		}
		
		/**
		 * Removes from the underlying collection the last 
		 * element returned by this iterator.
		 */
		@Override
		public void remove(){
			if(lastReturned == null)
				throw new IllegalStateException();
			
			Node prevLastReturned = lastReturned.prev;
			
			if(prevLastReturned == null){
				headList = next;
			} 
			else{
				prevLastReturned.next = next;
			}
			
			if(lastReturned.next == null){
				tailList = prevLastReturned;
			}
			else{
				lastReturned.next.prev = prevLastReturned;
			}
			
			lastReturned = null;
			
			size--;
			index--;
			
		}
	}
	
	/**
	 * Returned the iterator of this list.
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
			if(!hasPrevious())
				throw new NoSuchElementException();
			
			lastReturned = next = (next == null) ? tailList : next.prev;
            nextIndex--;
            return lastReturned.item;
		}
		
		/**
		 * Replaces the last element returned by next or previous with the specified element.
		 * 
		 * @param specific element which will replace.  
		 */
		@Override
		public void set(Object e) {
			if (lastReturned == null)
                throw new IllegalStateException();
  
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
