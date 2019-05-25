package avl;

import bst.DennBST;
import bst.DennNode;

@SuppressWarnings("rawtypes")
public class DennAVLTree<K extends Comparable, V> extends DennBST<K, V>  {

	@Override
	public void addNode(K key, V value) {
		// TODO Auto-generated method stub
		if(key!=null && value!=null) {
			DennAVLNode<K,V> z = new DennAVLNode<K,V>(key,value);
			addNode(z);
			insertFixeUp(z);
		}
		
	}
	
	private void insertFixeUp(DennAVLNode<K, V> z) {
		DennAVLNode<K,V> N = z;
		DennAVLNode<K,V> P = (DennAVLNode<K, V>) z.getParent();
		if(P!=null) {
			do {
		
				DennAVLNode<K,V> left = (DennAVLNode<K, V>) P.getLeft();
				
				 if (left != null && N.compareTo(left)==0) {  
					 
					 if (P.getBalanceFactor() == 1) { 
						
						 if (N.getBalanceFactor() == -1) { 
							 rotationToLeft(N); 
							 N.updateFactorBalance();
							 ((DennAVLNode)N.getParent()).updateFactorBalance();
						 }
			
						 rotationToRight(P);
						 
						 P.updateFactorBalance();
						 
						 ((DennAVLNode)P.getParent()).updateFactorBalance();
						 break; 
					 }
					 if (P.getBalanceFactor() == -1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 
					 P.setBalanceFactor(1); 
				 } 
				 else { 
					 if (P.getBalanceFactor() == -1) { 
						 
						 if (N.getBalanceFactor() == 1) { 
							 rotationToRight(N); 
							 N.updateFactorBalance();
							 ((DennAVLNode)N.getParent()).updateFactorBalance();
						 }
						
						 rotationToLeft(P);
						 P.updateFactorBalance();
						 ((DennAVLNode)P.getParent()).updateFactorBalance();
						 break; 
					 }
					 if (P.getBalanceFactor() == 1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 P.setBalanceFactor(-1); 
				 }
				 N = P;
				 P = (DennAVLNode<K, V>) N.getParent();
			}while(P!=null);
		}
	}

	@Override
	public DennNode<K, V> deleteNode(K key) {
		// TODO Auto-generated method stub
		if(key==null) {
			return null;
		}
		DennNode<K,V>z = searchNode(key);
		DennNode[] params = null;
		
		if(z!=null) {
			params = deleteNode(z);
		}else {
			return null;
		}
		deleteFixeUp((DennAVLNode)params[0]);
		return params[1];
	}
	
	private void deleteFixeUp(DennAVLNode N) {
		DennAVLNode G = null;
		for(DennAVLNode X = (DennAVLNode) N.getParent(); X != null; X = G) { 
		    G = (DennAVLNode) X.getParent(); 
		    if (N == X.getLeft()) {
		        if (X.getBalanceFactor() < 0) { 
		        	DennAVLNode Z = (DennAVLNode) X.getRight();
		            int b = Z.getBalanceFactor();
		            if (b > 0) {
		            	rotationToRight(Z);
		            	Z.updateFactorBalance();
		            	rotationToLeft(X);
		            	X.updateFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	rotationToLeft(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.getBalanceFactor() == 0) {
		                X.setBalanceFactor(-1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    } else { 
		        if (X.getBalanceFactor() > 0) {
		            DennAVLNode Z = (DennAVLNode) X.getLeft();
		            int b = Z.getBalanceFactor();
		            if (b < 0) {
		            	rotationToLeft(Z);
		            	Z.updateFactorBalance();
		            	rotationToRight(X);
		            	X.updateFactorBalance();
		            }else {
		            	rotationToRight(X);
		            	X.updateFactorBalance();
		            }
		        } else {
		            if (X.getBalanceFactor() == 0) {
		            	X.setBalanceFactor(1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    }
		}
	}

}
