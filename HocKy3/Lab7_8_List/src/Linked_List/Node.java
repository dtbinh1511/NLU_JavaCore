package Linked_List;

public class Node<E> {
	public Node<E> next;
	public Node<E> previous;
	public E data;

	public Node() {
		this.next = null;
		this.data = null;
		this.previous = null;
	}

	public Node(E e) {
		data = e;
		next = null;
		previous =null;
	}

//	public Node(Node<E> next, E data) {
//		super();
//		this.next = next;
//		this.data = data;
//	}
	
}
