package avl;

import bst.DennNode;

public class DennAVLNode<K,V> extends DennNode {

	private int balanceFactor;
	
	public DennAVLNode(K key, V value) {
		super((Comparable)key, value);
		balanceFactor = 0;
	}
	

	public int getBalanceFactor() {
		if(getRight() == null && getLeft() == null) {
		}
		return balanceFactor;
	}
	
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}
	
	public void updateFactorBalance() {
		if(getRight() == null && getLeft() == null) {
			balanceFactor = 0;
		}
		else if(getRight() == null) {
			balanceFactor = getLeft().height;
		}
		else if(getLeft() == null) {
			balanceFactor = -getRight().height;
		}
		else {
			balanceFactor = getLeft().height-getRight().height;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void coverSubtree(String string, DennAVLNode nil) {
		System.out.println(string+"color: "+getValue()+" "+getKey());
		if( getLeft() != nil) {
			((DennAVLNode)getLeft()).coverSubtree(string+"L",nil);
		}
		if( getRight() != nil) {
			((DennAVLNode)getRight()).coverSubtree(string+"R",nil);

		}
	}
	
}
