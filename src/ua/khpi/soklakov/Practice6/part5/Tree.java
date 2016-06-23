package ua.khpi.soklakov.Practice6.part5;

/**
 * Class implements structure of data Binary Tree.
 * 
 * @author Jurkov.
 *
 * @param <E> elements of the Tree.
 */
public class Tree <E extends Comparable<E>> {
	
	/**
	 * Node of Tree.
	 * 
	 * @author Jurkov.
	 *
	 */
	private class Node {
		E element;
		Node left, right;
		public Node (E key) {
			this.element = key;
			this.left = this.right = null;
		}
	}
	
	private Node root;
	
	private Node add (Node node,E element){
		if (node == null){
			Node newnode = new Node(element);
			return newnode;
		}
		int compareResult = element.compareTo(node.element);
                if(compareResult == 0) {
                    node.element = element;
                    return node;
                }
                else if(compareResult < 0)
                    node.left = add(node.left, element);
                else 
                    node.right = add(node.right, element);
        return node;
	}          
	
	/**
	 * Returned true if element do not exists in tree before add.
	 * Else returned false.
	 * 
	 * @param element specified element to add.
	 * @return Returned true if element do not exists in tree before add.
	 *         Else returned false.
	 */
	public boolean add(E element) {
		E elem = get(element);
		
		root = add(root, element);
		
		if(elem == null){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Add specified array of type E.
	 * 
	 * @param elements specified array of type E.
	 */
	public void add(E[] elements){
		for(E elem : elements){
			add(elem);
		}
	}
	
    /**
     * Returned True if element exists in tree and removed.
     * 			Else false. 
     * 
     * @param element specified element to remove.
     * @return True if element exists in tree and removed.
     * 		   Else false.
     */
	public boolean remove(E element) {
            Node cur = root;
            Node prev = null;
    
            for(; true; ){
                if(cur == null) return false;
                if(element.compareTo(cur.element) < 0){
                    prev = cur; cur = cur.left;
                }
                else if(element.compareTo(cur.element) > 0){
                    prev = cur;
                    cur = cur.right;
                }
                else break;
            }
          
             if(cur.right == null)
                    
                    if(prev == null){ 
                        root = root.left;
                    }
                    else if(cur == prev.right)
                        prev.right = cur.left;
                    else
                        prev.left = cur.left;
                
                else if(cur.left == null)
                    
                    if(prev == null){ 
                        root = root.left;
                    }
                    else if(cur == prev.right)
                            prev.right = cur.left;
                    else
                            prev.left = cur.left;
 
                else{
                    Node mostLeft = cur.right;
                    prev = null;
                    for(; mostLeft.left != null;){
                        prev = mostLeft;
                        mostLeft = mostLeft.left;
                    }
                    if(prev != null)
                        prev.left = mostLeft.right;
                    else
                        cur.right = mostLeft.right;
                    cur.element = mostLeft.element;
                    cur.element = mostLeft.element;
                }
             
             E elem = get(element);
             
             if(elem == null){
            	 return true;
             }else{
            	 return false;
             }
	}
	
	/**
	 * Returned element of type E if it exists in tree.
	 * 
	 * @param element specified element to get.
	 * @return element of type E if it exists in tree
	 */
	public E get(E element) {
            Node cur = root;
            for(; true; ){
                if(cur == null) 
                	break;
                if(element.compareTo(cur.element) < 0)
                    cur = cur.left;
                else if(element.compareTo(cur.element) > 0)
                    cur = cur.right;
                else 
                	break;
            }
            return cur != null? cur.element : (E)null;
	}
	
	private void print(Node node, int level) {
		if (node != null) {
			print(node.left, level + 1);
			for (int i=0; i < level; i++) {
				System.out.print("  ");
			}
			System.out.println(node.element); 
			print(node.right, level + 1);
		
		}
	}
	
	/**
	 * Print tree from up to down.
	 * 
	 */
	public void print() {
		print(root, 0);
	}
	
	/**
	 * main.
	 * 
	 * @param args //.
	 */
	public static void main(String[] args){
		Tree<Integer> tree = new Tree<>();
		
		System.out.println(tree.add(3));
		System.out.println(tree.add(3));
		
		System.out.println("~~~~~~~");
		
		tree.add(new Integer[] {1, 2, 5, 4, 6, 0});
		
		tree.print();
		
		System.out.println("~~~~~~~");
		
		System.out.println(tree.remove(5));
		System.out.println(tree.remove(5));  
		
		System.out.println("~~~~~~~");
		
		tree.print();
	}
}