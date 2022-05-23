package Linked_List;

public class MyLinkedList<E> {
	private int size = 0;
	private Node<E> head = null;
	private Node<E> tail = null;

	public MyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		if (isEmpty())
			return null;
		return head.data;
	}

	// Returns (but does not remove) the last element in the list.

	public E last() {
		if (isEmpty())
			return null;
		return tail.data;
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newest = new Node<E>(e);
		if (isEmpty()) {
			head = newest;
		} else {
			newest.next = head;
			head = newest;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e);
		if (isEmpty()) {
			head = newest;
		} else {
			newest.next = null;
			tail.next = newest;
			tail = newest;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (isEmpty())
			return null;
		E result = head.data;
		head = head.next;
		size--;

		return result;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (isEmpty())
			return null;
		E result = tail.data;
		int i = 0;
		while (i < size) {
			tail = head.next;
			i++;
		}
		size--;
		return result;
	}
}
