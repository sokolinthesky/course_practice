package ua.khpi.soklakov.Practice2;

import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		MyListImpl list = new MyListImpl();
		
		list.add(new String("a"));
		list.add(new String("c"));
		list.add(433);
		list.add(new String("n"));
		
		System.out.println("Size of list = " + list.size());
		
		for(Object object : list){
			System.out.println(object);
		}
		
		Iterator<Object> itrList = list.iterator();
		while(itrList.hasNext()){
			System.out.println(itrList.next());	
		}
		
		System.out.println(list);
		
		MyList testList = new MyListImpl();
		
		testList.add("a");
		testList.add(433);
		
		System.out.println("Does contains teseList in list ? = " +
						   list.containsAll(testList));
		
		System.out.println("Does contains element 'a' in list ? = " + 
						   list.contains("a"));
		
		Object[] arrayOfList = list.toArray();
		String strArrayOfList = "";
		
		for(Object element : arrayOfList)
			strArrayOfList = strArrayOfList + element + ","; 
		
		System.out.println("To array list = " + strArrayOfList);
		
		System.out.println("Does delete element = 433 ? " + list.remove(433));
		
		list.remove("c");
		System.out.println("Remove " + list);
		
		ListIterator listIterator = list.listIterator();
		
		while(listIterator.hasPrevious()){
			System.out.println("previous: " + listIterator.previous());
		}
	}
}
