package lab11_tree_T.Du;

import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {

	private E data;
	private BNode<E> myLeft;
	private BNode<E> myRight;

	public BNode(E data) {
		this.data = data;
		this.myLeft = null;
		this.myRight = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.myLeft = left;
		this.myRight = right;
	}

	public String toString() {
		if (myLeft == null && myRight == null)
			return data.toString();
		else if (myLeft != null && myRight == null)
			return data.toString() + " " + myLeft.toString();
		else if (myLeft == null && myRight != null)
			return data.toString() + " " + myRight.toString();
		return data.toString() + " " + myLeft.toString() + " " + myRight.toString();
	}

	public int compareTo(E e) {
		return data.compareTo(e);
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getMyLeft() {
		return myLeft;
	}

	public void setMyLeft(BNode<E> myLeft) {
		this.myLeft = myLeft;
	}

	public BNode<E> getMyRight() {
		return myRight;
	}

	public void setMyRight(BNode<E> myRight) {
		this.myRight = myRight;
	}

	public int size() {
		if (myLeft == null && myRight == null)
			return 1;
		else if (myLeft != null && myRight == null)
			return 1 + myLeft.size();
		else if (myLeft == null && myRight != null)
			return 1 + myRight.size();
		else
			return 1 + myLeft.size() + myRight.size();
	}

	public int depth(E e) {
		if (this.data.compareTo(e) == 0)
			return 0;
		else if (this.data.compareTo(e) > 0)
			return 1 + myLeft.depth(e);
		else
			return 1 + myRight.depth(e);
	}

	public boolean constain(E e) {
		if (this.data.compareTo(e) == 0)
			return true;
		if (myLeft == null && myRight == null)
			return false;
		if (this.data.compareTo(e) > 0 && myLeft == null)
			return false;
		if (this.data.compareTo(e) < 0 && myRight == null)
			return false;
		if (this.data.compareTo(e) > 0)
			return myLeft.constain(e);
		return myRight.constain(e);
	}

	public int height() {
		if (myLeft == null && myRight == null)
			return 0;
		if (myLeft != null && myRight == null)
			return 1 + myLeft.height();
		if (myLeft == null && myRight != null)
			return 1 + myRight.height();
		return 1 + Math.max(myLeft.height(), myRight.height());
	}

	public E findMin() {
		if (myLeft == null)
			return this.data;
		if (this.data.compareTo(myLeft.data) < 0)
			return this.data;
		return myLeft.findMin();
	}

	public E findMax() {
		if (myRight == null)
			return this.data;
		if (this.data.compareTo(myRight.data) > 0)
			return this.data;
		return myRight.findMax();
	}

	public BNode<E> remove(BNode<E> node, E e) {
		if (node.data.compareTo(e) > 0)
			node.myLeft = remove(node.myLeft, e);
		else if (node.data.compareTo(e) < 0)
			node.myRight = remove(node.myRight, e);
		else {
			if (node.myLeft == null && node.myRight == null)
				return null;
			else if (node.myLeft == null)
				return node.myRight;
			else if (node.myRight == null)
				return node.myLeft;
			else {
				node.data = node.myLeft.findMax();
				node.myLeft = remove(node.myLeft, node.data);
			}
		}
		return node;
	}

	public BNode<E> remove(E e) {
		if (data.compareTo(e) > 0)
			myLeft = myLeft.remove(e);
		else if (data.compareTo(e) < 0)
			myRight = myRight.remove(e);
		else {
			if (myLeft == null && myRight == null)
				return null;
			if (myLeft == null)
				return myRight;
			if (myRight == null)
				return myLeft;
			data = myLeft.findMax();
			myLeft = myLeft.remove(data);
		}
		return this;
	}

	public List<E> descendants(E e, BNode<E> node) {
		List<E> list = new ArrayList<E>();
		if (node == null)
			return list;
		else if (node.data == e)
			return list;
		else {
			list.add(node.data);
			if (e.compareTo(node.data) > 0)
				list.addAll(descendants(e, node.myRight));
			if (e.compareTo(node.data) < 0)
				list.addAll(descendants(e, node.myLeft));
		}
		return list;
	}
	
	public List<E> ancestors(E e, BNode<E> node){
		List<E> list = new ArrayList<E>();
		if (node == null)
			return list;
		if (e.compareTo(node.data) > 0)
			list = ancestors(e, node.myRight);
		else if (e.compareTo(node.data) < 0)
			list = ancestors(e, node.myLeft);
		else {
			if (node.myLeft == null && node.myRight == null)
				return list;
			else if (node.myLeft == null) {
				list.add(node.myRight.data);
				list.addAll(ancestors(node.myRight.data, node.myRight));
			}else if (node.myRight == null) {
				list.add(node.myLeft.data);
				list.addAll(ancestors(node.myLeft.data, node.myLeft));
			}else {
				list.add(node.myLeft.data);
				list.add(node.myRight.data);
				list.addAll(ancestors(node.myRight.data, node.myRight));
				list.addAll(ancestors(node.myLeft.data, node.myLeft));
			}
		}
		return list;
	}
}
