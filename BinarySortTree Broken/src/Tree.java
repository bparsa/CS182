import java.util.ArrayList;


public class Tree <E extends Comparable<E>>{
	//variables
	private Node<E> root = null;
	private int size = 0;
	
	// constructor
	public Tree() {
		
	}
	
	// get root
	public Node<E> getRoot() {
		return root;
	}
	
	// getSize
	public int getSize() {
		return size;
	}
	
	// public treeSearch method, finds k in tree and returns that node
	public Node<E> treeSearch(E k) {
		// set current to root of tree
		Node<E> cur = root;
		
		// while root is not null and target element is not current
		while (cur != null && k != cur.get()) {
			// compare target with current node
			// if target is less than current, go left in tree
			if (k.compareTo(cur.get()) == -1) {
				cur = cur.getLeft();
			}
			// else go right in tree
			else {
				cur = cur.getRight();
			}
		}
		// return current, will be null if target was not found
		return cur;
	}
	
	// method treeMax, returns min of subtree of Node x
	private Node<E> treeMin(Node<E> x) {
		// while node's left child is not null
		while (x.getLeft() != null) {
			// go to left child of current node
			x = x.getLeft();
		}
		return x;
	}
	
	// method treeMax, returns max of subtree of Node x
	private Node<E> treeMax(Node<E> x) {
		while (x.getRight() != null) {
			x = x.getRight();
		}
		return x;
	}
	
	// method treeSuccessor - gets successor node of Node n
	private Node<E> treeSuccessor (Node<E> n) {
		// set current to Node n
		Node<E> x = n;
		// if node has a right child, return leftmost node of right child
		if (x.getRight() != null) {
			return treeMin(x.getRight());
		}
		// if no right child, set y to parent of node
		Node<E> y = x.getParent();
		// while parent is not null (root), and node is right child of parent
		while (y != null && x == y.getRight()) {
			// set cur node to it's parent
			x = y;
			// set parent to current grandparent of x
			y = y.getParent();
		}
		return y;
	}
	
	// public method treeInsert
	public void treeInsert (E k) {
		Node<E> z = new Node<E>(k);
		treeInsert(this, z);
	}
	
	// private method insert
	private void treeInsert (Tree<E> t, Node<E> z) {
		// set parent to null
		Node<E> y = null;
		// set current to root
		Node<E> x = t.root;
		
		// while current is not null
		while (x != null) {
			// set parent to current
			y = x;
			// if node to be inserted is less than current, go to left child
			if (z.get().compareTo(x.get()) == -1) {  // z.get() < x.get()
				x = x.getLeft();
			}
			// else go to right child
			else {
				x = x.getRight();
			}
		}
		// set parent of node to be inserted to y
		z.setParent(y);
		// if y was null, it's child was root, so insert node at root
		if (y == null) {
			t.root = z;   // tree was empty
			size++;  // increment size
		}
		// if y is greater than z
		else if (z.get().compareTo(y.get()) == -1) {  // z.get() < y.get()
			// set y's left child to z
			y.setLeft(z);
			size++;  // increment size
		}
		// else set y right child to z
		else {
			y.setRight(z);
			size++;
		}
	}
	
	// public method transplant - to assist with treeDelete method
	private void transplant(Tree<E> t, Node<E> u, Node<E> v) {
		// root case
		if (u.getParent() == null) {
			t.root = v;
		}
		// if u is a left child, set parent's left pointer to v
		else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		}
		// else if u is a right child set parent's right pointer to v
		else {
			u.getParent().setRight(v);
		}
		// set v's parent to it's grandparent
		if (v != null) {
			v.setParent(u.getParent());
		}
	}
	
	// public method treeDelete, calls treeDelete on itself
	public void treeDelete(E k) {
		Node<E> z = treeSearch(k);
		if (z != null) {
			treeDelete(this, z);
		}
	}
	
	// public method treeDelete, deletes node z from BST
	private void treeDelete(Tree<E> t, Node<E> z) {
		Node<E> y;
		// if z has no left child
		if (z.getLeft() == null) {
			transplant(t, z, z.getRight());
		}
		// if z has a left child but no right child
		else if (z.getRight() == null) {
			transplant(t, z, z.getLeft());
		}
		// if z has both left and right child
		else {
			// set y to successor
			y = treeMin(z.getRight());
			// if successor's parent isn't node to be deleted
			if (y.getParent() != z) {
				transplant(t, y, y.getRight());
				y.setRight(z.getRight());
				// set parent of right of y to y
			}
			transplant(t, z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}
	
	// public method print tree
	public void printTree() {
		printTree(root);
	}
	
	// private method print tree
	private void printTree(Node<E> n) {
		if (n == null) {
			return;
		}
		printTree(n.getLeft());
		System.out.print(n.get().toString() + " ");
		printTree(n.getRight());
	}
	
	// method find depth
	public int treeDepth() {
		return treeDepth(root);
	}
	
	// private recursive method treeDepth
	private int treeDepth(Node<E> n) {
		if (n == null) {
			return 0;
		}
		else {
			return 1 + Math.max(treeDepth(n.getLeft()), treeDepth(n.getRight()));
		}
	}
	
	// method treeCreate, creates balanced BST if input array is sorted.
	public void treeCreate(ArrayList<E> al) {
		treeCreate(al, 0,  al.size()-1);
	}
	
	private void treeCreate(ArrayList<E> al, int start, int end) {
		if (start > end) {
			return;
		}
		int mid = (start + end)/2;
		treeInsert(al.get(mid));
		treeCreate(al, start, mid - 1);
		treeCreate(al, mid + 1, end);
	}
}
