package bst;


public abstract class DennNode<K extends Comparable, V> implements Comparable{

	private K key;
	private V value;
	public int height;
	
	private DennNode<K, V> parent;
	private DennNode<K, V> right;
	private DennNode<K, V> left;
	private DennNode<K, V> clone;
	
	public DennNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public DennNode<K, V> getParent() {
		return parent;
	}

	public void setParent(DennNode<K, V> parent) {
		this.parent = parent;
	}

	public DennNode<K, V> getRight() {
		return right;
	}

	public void setRight(DennNode<K, V> right) {
		this.right = right;
	}

	public DennNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(DennNode<K, V> left) {
		this.left = left;
	}

	public DennNode<K, V> getClone() {
		return clone;
	}

	public void setClone(DennNode<K, V> clone) {
		this.clone = clone;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void updateHeight() {
		if(right == null && left == null) {
			height=-1;
		}
		else if (right == null) {
			height=left.height;
		}
		else if (left == null) {
			height = right.height;
		}
		else {
			height = Math.max(right.height, left.height);
		}
		height++;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compareTo(Object o) {
		return key.compareTo(((DennNode)o).key);
	}
	
	
}
