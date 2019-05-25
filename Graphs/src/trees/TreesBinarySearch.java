package trees;

public class TreesBinarySearch<T extends Comparable<T>> extends TreeBinarySearchNode<T> {

	protected TreeBinarySearchNode<T> root;

	public TreesBinarySearch() {
		root = null;
	}

	public TreesBinarySearch(TreesBinarySearch<T> root) {
		this.root = root;
	}

	public TreeBinarySearchNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeBinarySearchNode<T> root) {
		this.root = root;
	}
	

	public void insertNode(T data, TreeBinarySearchNode<T> node) {

		if (data.compareTo(node.getData()) < 0) {

			if (node.getSonLeft() == null) {
				node.setSonLeft(new TreeBinarySearchNode<>(data));

			} else {
				insertNode(data, node.getSonLeft());
			}

		} else {
			if (node.getSonRight() == null) {
				node.setSonRigth(new TreeBinarySearchNode<>(data));
			} else {
				insertNode(data, node.getSonRight());
			}

		}
	}
	

	public void insertNode(T data) {
		TreeBinarySearchNode<T> treeNode = new TreeBinarySearchNode<T>();
		treeNode.setData(data);
		if (root == null) {
			setRoot(treeNode);
		} else {
			insertNode(data, root);

		}
	}

	public TreeBinarySearchNode<T> maximum() {
		TreeBinarySearchNode<T> node = root;
		if (node == null) {
			return null;
		} else {

			node = root;
			while (node.getSonRight() != null) {
				node = node.getSonRight();
			}
			return node;
		}
	}
	

	public TreeBinarySearchNode<T> minimum(TreeBinarySearchNode<T> node){
		
		if(node==null){
			return null;
		}
		else {

			while(node.getSonLeft()!=null){
				node=   node.getSonLeft();
			}
			return node;
		}
	}
	
	
	public TreeBinarySearchNode<T> successor(TreeBinarySearchNode<T> node){
		
		if(node.getSonRight()!=null) {
			return minimum(node.getSonRight());
		}
		
		TreeBinarySearchNode<T> y= node.getParent();
		
		while(y!=null && node== y.getSonRight()) {
			node=y;
			y=y.getParent();
		
		}
		return y;		
	}
	
	
	public void inOrder(TreeBinarySearchNode<T> node) {
		if (node==null) {
			return ;
		}
		inOrder(node.getSonLeft());
		System.out.println(node.getData()+ " ");
		inOrder(node.getSonRight());
	}
	
	
	
	public TreeBinarySearchNode<T> searchNode (T data, TreeBinarySearchNode<T> node ) {
		if(root==null) {
			return null;
		}
		else {
			if (node==null || data.compareTo(node.getData())==0 ) {
				return node;
			}
			else if(data.compareTo(node.getData())<0) {
				return searchNode(data, node.getSonLeft());

			}
			else {
				return searchNode(data, node.getSonRight());
			}
		}
	}
 	
}
