package trees;

public class TreeBinarySearchNode<T> {

	protected T data;
	protected TreeBinarySearchNode<T> sonLeft;
	protected TreeBinarySearchNode<T> sonRight;
	protected TreeBinarySearchNode<T> parent;
	
	public TreeBinarySearchNode() {
		
	}
	
	public TreeBinarySearchNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public TreeBinarySearchNode<T> getSonLeft() {
		return sonLeft;
	}
	public void setSonLeft(TreeBinarySearchNode<T> sonLeft) {
		this.sonLeft = sonLeft;
	}
	
	public TreeBinarySearchNode<T> getSonRight() {
		return sonRight;
	}
	public void setSonRigth(TreeBinarySearchNode<T> sonRight) {
		this.sonRight = sonRight;
	}
	
	public TreeBinarySearchNode<T> getParent() {
		return parent;
	}
	public void setParent(TreeBinarySearchNode<T> parent) {
		this.parent = parent;
	}
	
}
