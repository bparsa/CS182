
public class Node <E extends Comparable <E>> {
	//variables
	private E key;
	private Node<E> left;
	private Node<E> right;
	private Node<E> parent;
	
	//constructor
	public Node (E x) {
		key = x;
		left = null;
		right = null;
		parent = null;
	}
	
	//get key
	public E get() {
		return key;
	}
	
	public Node<E> getLeft() {
		return left;
	}
	
	public Node<E> getRight() {
		return right;
	}
	
	public Node<E> getParent() {
		return parent;
	}
	
	public void setElement(E anE) {
		key = anE;
	}
	
	public void setLeft(Node<E> n) {
		left = n;
	}
	
	public void setRight(Node<E> n) {
		right = n;
	}
	
	public void setParent(Node<E> n) {
		parent = n;
	}

}
