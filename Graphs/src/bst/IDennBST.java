package bst;



public interface IDennBST<K extends Comparable, V> {
	
	public void addNode(K key, V value);
	public DennNode<K, V> deleteNode(K key);

}
