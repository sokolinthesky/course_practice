package ua.khpi.soklakov.Practice2;

import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		MyListImpl list = new MyListImpl();

		for (int i = 0; i < 16; i++) {
			list.add(i);
		}

		System.out.println("ORIGINAL LIST:");
		System.out.println(list);
		System.out.println("LIST SIZE: " + list.size() + "\n");

		list.add(16);
		list.add(15);
		System.out.println("LIST SIZE AFTER ADD: " + list.size());
		System.out.println(list + "\n");

		list.remove(15);
		System.out.println("LIST AFTER REMOVE:");
		System.out.println(list);
		System.out.println("LIST SIZE AFTER REMOVE: " + list.size() + "\n");

		System.out.println("CONTAINS RESOULT: " + list.contains(0) + "\n");

		MyListImpl listTwo = new MyListImpl();
		listTwo.add(1);
		listTwo.add(2);
		System.out.println("CONTAINS ALL RESOULT: " + list.containsAll(listTwo));

		MyListImpl con = new MyListImpl();
		con.add(1);
		con.add(2);
		con.add(3);

		for (Object o : con) {
			System.out.println(o);
		}

		Iterator<Object> it = con.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
