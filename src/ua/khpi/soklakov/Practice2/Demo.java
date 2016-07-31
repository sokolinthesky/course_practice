package ua.khpi.soklakov.Practice2;

import java.util.Iterator;

public class Demo {
	
	/**
	 * Main method.
	 * Test.
	 * @param args
	 */
	public static void main(String[] args) {
		MyListImpl list = new MyListImpl();
		
		System.out.println("Test adding:");
		list.add("e");
		list.add("cn");
		list.add(133);
		list.add("ncc");

		System.out.println("Size of list after adding = " + list.size());

		System.out.println("iterator test:");
		Iterator<Object> itratorList = list.iterator();
		while (itratorList.hasNext()) {
			System.out.println(itratorList.next());
		}
		
		System.out.println("for each test:");
		for (Object object : list) {
			System.out.println(object);
		}

		System.out.println("list items:");
		System.out.println(list);

		MyList newList = new MyListImpl();
		newList.add("e");
		newList.add(133);
		System.out.println("Does contains teseList in list? = " + list.containsAll(newList));
		System.out.println("Does contains element 'e' in list? = " + list.contains("e"));

		Object[] array = list.toArray();
		String strArrayOfList = "";

		for (Object element : array) {
			strArrayOfList = strArrayOfList.concat(element + ",");
		}
		System.out.println("Test to array list = " + strArrayOfList);

		System.out.println("delete element 133 " + list.remove(133));

		list.remove("cn");
		System.out.println("Result after remove remove " + list);
		ListIterator listIterator = list.listIterator();

		System.out.println("Previous test:");
		while (listIterator.hasPrevious()) {
			System.out.println("previous: " + listIterator.previous());
		}
	}
}
