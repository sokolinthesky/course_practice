package ua.khpi.soklakov.Practice6.part5;

/**
 * The class implements structure of data Binary Tree.
 * 
 * @author Soklakov Oleg.
 *
 * @param <E>
 *            elements of the Tree.
 */
public class MyTree<E extends Comparable<E>> {

	/**
	 * Node of tree.
	 */
	private Node root;

	/**
	 * main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyTree<Integer> myTree = new MyTree<>();
		System.out.println("try add - " + myTree.add(3));
		System.out.println("try add - " + myTree.add(3));
		System.out.println("=========");
		myTree.add(new Integer[] { 1, 2, 5, 4, 6, 0 });
		myTree.printTree();
		System.out.println("~~~~~~~");
		System.out.println("try remove -" + myTree.remove(5));
		System.out.println("try remove -" + myTree.remove(5));
		System.out.println("~~~~~~~");
		myTree.printTree();
	}

	/**
	 * Method returned true if element do not exists in tree before add. Else
	 * returned false.
	 * 
	 * @param element
	 *            specified element to add.
	 * @return Returned true if element do not exists in tree before add. Else
	 *         returned false.
	 */
	public boolean add(E element) {
		E e = get(element);
		root = add(root, element);

		if (e == null) {
			return true;
		}

		return false;
	}

	/**
	 * Add specified array of type E.
	 * 
	 * @param elements
	 *            specified array of type E.
	 */
	public void add(E[] elements) {
		for (E elem : elements) {
			add(elem);
		}
	}

	/**
	 * Returned element of type E if it exists in tree.
	 * 
	 * @param element
	 *            specified element to get.
	 * @return element of type E if it exists in tree
	 */
	public E get(E element) {
		Node cur = root;
		for (; true;) {
			if (cur == null) {
				break;
			} else if (element.compareTo(cur.element) < 0) {
				cur = cur.left;
			} else if (element.compareTo(cur.element) > 0) {
				cur = cur.right;
			} else {
				break;
			}
		}
		return cur != null ? cur.element : (E) null;
	}

	/**
	 * Method returned True if element exists in tree and removed. Else false.
	 * 
	 * @param element
	 *            specified element to remove.
	 * @return True if element exists in tree and removed. Else false.
	 */
	public boolean remove(E element) {
		Node current = root;
		Node previous = null;

		for (; true;) {
			if (current == null) {
				return false;
			}
			if (element.compareTo(current.element) < 0) {
				previous = current;
				current = current.left;
			} else if (element.compareTo(current.element) > 0) {
				previous = current;
				current = current.right;
			} else {
				break;
			}
		}

		if (current.right == null) {

			if (previous == null) {
				root = root.left;
			} else if (current == previous.right) {
				previous.right = current.left;
			} else {
				previous.left = current.left;
			}

		} else if (current.left == null) {

			if (previous == null) {
				root = root.left;
			} else if (current == previous.right) {
				previous.right = current.left;
			} else {
				previous.left = current.left;
			}
		} else {
			Node mostLeft = current.right;
			previous = null;
			for (; mostLeft.left != null;) {
				previous = mostLeft;
				mostLeft = mostLeft.left;
			}
			if (previous != null) {
				previous.left = mostLeft.right;
			} else {
				current.right = mostLeft.right;
				current.element = mostLeft.element;
				current.element = mostLeft.element;
			}
		}

		E elem = get(element);
		boolean res = (elem == null);

		return res;
	}

	private void print(Node node, int level) {
		if (node != null) {
			print(node.left, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("  ");
			}
			System.out.println(node.element);
			print(node.right, level + 1);

		}
	}

	/**
	 * Node of Tree.
	 * 
	 * @author Soklakov Oleg.
	 *
	 */
	private class Node {
		private E element;
		private Node left;
		private Node right;

		public Node(E key) {
			this.element = key;
			this.left = this.right = null;
		}
	}

	/**
	 * Inner method for adding element.
	 * 
	 * @param node
	 *            specified Node.
	 * @param element
	 *            specified element
	 * @return Node.
	 */
	private Node add(Node node, E element) {
		if (node == null) {
			return new Node(element);
		}
		int compareResult = element.compareTo(node.element);
		if (compareResult == 0) {
			node.element = element;
			return node;
		} else if (compareResult < 0) {
			node.left = add(node.left, element);
		} else {
			node.right = add(node.right, element);
		}
		return node;
	}

	/**
	 * Print tree from up to down.
	 * 
	 */
	public void printTree() {
		print(root, 0);
	}
}