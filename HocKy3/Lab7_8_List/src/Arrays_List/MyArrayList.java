package Arrays_List;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int CAPACITY = 16;
	private E[] data;
	private int size = 0;

	public MyArrayList() {
		this(CAPACITY);
	}

	public MyArrayList(int capacity) {
		data = (E[]) new Object[capacity];
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size; i++) {
			result.append(data[i] + " ");
		}
		return result.toString();
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		return data[i];
	}

	/*
	 * Replaces the element at index i with e, and returns the replaced element.
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException {
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	// It is used to append the specified element at the end of a list.

	public boolean add(E e) {
		data[size++] = e;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		for (int j = size - 1; j > i; j--) {
			data[j + 1] = data[j];
		}
		data[i] = e;
		size++;
	}

	// Removes/returns the element at index i, shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		E temp = data[i];
		for (int j = i; j < size; j++) {
			data[j] = data[j + 1];
		}
		size--;
		return temp;
	}

	/*
	 * It is used to append all of the elements in the specified collection to the
	 * end of this list, in the order that they are returned by the specified
	 * collection's iterator.
	 */
	public boolean addAll(MyArrayList<E> c) {
		int csize = c.size;
		int index = size;
		System.arraycopy(data, index, data, csize + index, size - index);
		size += csize;
		return true;
	}

	// It is used to clear all elements in the list.
	public void clear() {
		if (size > 0) {
			Arrays.fill(data, 0, size, null);
		}
		size = 0;
	}

	/*
	 * It is used to return the index in this list of the last occurrence of the
	 * specified element, or -1 if the list does not contain this element.
	 */
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i >= 0; i--) {
			if (data[i].equals(o))
				return i;
		}
		return -1;
	}

	/*
	 * It is used to return an array containing all of the elements in this list in
	 * the correct order.
	 */
	public E[] toArray() {
		return Arrays.copyOfRange(data, 0, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
//		MyArrayList<E> clone = null;
//		clone.data = (E[]) data.clone();
//		return clone;
		return this;
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(o))
				return true;
		}
		return false;
	}

	/*
	 * It is used to return the index in this list of the first occurrence of the
	 * specified element, or -1 if the List does not contain this element.
	 */
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(o))
				return i;
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				data[i] = data[i + 1];
		}
		size--;
		return true;
	}

	/*
	 * It is used to sort the elements of the list on the basis of specified
	 * comparator.
	 */
	public void sort(Comparator<E> c) {
		Arrays.sort(data, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> my = new MyArrayList<>();
		my.add(3);
		my.add(2);
		my.add(4);
		my.add(1);
		my.add(10);
//		System.out.println(my.indexOf(4));
		System.out.println(my.toString());

	}
}
