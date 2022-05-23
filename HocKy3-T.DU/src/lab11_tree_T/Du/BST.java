package lab11_tree_T.Du;

import java.awt.Robot;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {

	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	@Override
	public String toString() {
		if (root == null)
			return null;
		return root.toString();
	}

	// Add element e into BST
	public void add(E e) {
		root = add(e, root);
	}

	public BNode<E> add(E e, BNode<E> node) {
		if (node == null)
			node = new BNode<E>(e);
		else if (node.compareTo(e) > 0)
			node.setMyLeft(add(e, node.getMyLeft()));
		else if (node.compareTo(e) < 0)
			node.setMyRight(add(e, node.getMyRight()));
		return node;
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null)
			return -1;
		if (!constain(node))
			return -1;
		return root.depth(node);
	}

	// compute the height of in BST
	public int height() {
		if (root == null)
			return -1;
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		if (root == null)
			return 0;
		return root.size();
	}

	// Check whether element e is in BST
	public boolean constain(E e) {
		if (root == null)
			return false;
		return root.constain(e);
	}

	// Find the minimun element in BST
	public E findMin() {
		if (root == null)
			return null;
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null)
			return null;
		return root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null)
			return false;
		else if (!constain(e))
			return false;
		else {
			root = root.remove(e);
			return true;
		}
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		return root.descendants(data, root);
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return root.ancestors(data, root);
	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		bst.add(50);
		bst.add(20);
		bst.add(70);
		bst.add(10);
		bst.add(30);
		bst.add(7);

//		System.out.println(bst);
//		System.out.println(bst.size());
//		System.out.println(bst.depth(15));
//		System.out.println(bst.constain(15));
//		System.out.println(bst.height());
//		System.out.println(bst.findMin());
//		System.out.println(bst.findMax());
//		System.out.println(bst);
//		System.out.println(bst.remove(2));
//		System.out.println(bst);
//		System.out.println(bst.descendants(30));
		System.out.println(bst.ancestors(20)); 
	}
}
