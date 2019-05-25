package bst;



public abstract class DennBST<K extends Comparable, V> implements IDennBST<K, V> {

	protected DennNode<K, V> root;
	protected DennNode<K, V> nil;
	
	public DennBST() {
		nil = null;
		root = nil;
	}
	
	
	public DennNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(DennNode<K, V> root) {
		this.root = root;
	}

	public DennNode<K, V> getNil() {
		return nil;
	}


	public void setNil(DennNode<K, V> nil) {
		this.nil = nil;
	}

	public abstract void addNode(K key, V value);
	public abstract DennNode<K,V> deleteNode(K key);

	
	public void addNode(DennNode<K, V> z) {
		DennNode<K, V> y = null;
		
		if (nil != null)
			y = (DennNode<K, V>) nil;
		
		DennNode<K, V> x = root;
		
		while (x != nil) {
			y = x;
			
			if (x.compareTo(z) > 0) {   
				
				DennNode<K, V> parent = x;
				x = x.getLeft();
				
				if (x != nil && parent.height == x.height + 1) {
					parent.height++;
				}
				
				if (parent.getRight() == nil && x == nil) {
					parent.height++;
				}
				
			} 
			else if (x.compareTo(z) < 0) {
				DennNode<K, V> parent = x;
				x = x.getRight();
				
				if (x != nil && parent.height == x.height + 1) {
					parent.height++;
				}
				
				if (parent.getLeft() == nil && x == nil) {
					parent.height++;
				}
			} 
			else {
				DennNode<K, V> w = x.getClone();
				
				while (w != null) {
					x = w;
					w = w.getClone();
				}
				
				x.setClone(z);
				DennNode<K, V> p = null;
				
				if (nil != null) {
					p = (DennNode<K, V>) nil;
				}
					
				z.setRight(p);
				z.setLeft(p);
				z.setParent(p);
				return;
			}
		}
		z.setParent(y);
		if (y == nil) {
			root = z;
		} 
		else if (y.compareTo(z) > 0) {
			y.setLeft(z);
		} 
		else {
			y.setRight(z);
		}
		DennNode<K, V> p = null;
		if (nil != null) {
			p = (DennNode<K, V>) nil;
		}
			
		z.setRight(p);
		z.setLeft(p);
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public DennNode<K, V> searchNode(K key){
		if(key == null) {
			return null;
		}
		
		DennNode<K, V> y = null;
		
		if (nil != null) {
			y = (DennNode<K, V>) nil;
		}
			
		DennNode<K, V> x = root;
		
		while (x != nil) {
			y = x;
			if (x.getKey().compareTo(key) > 0) {
				x = x.getLeft();
			} 
			else if (x.getKey().compareTo(key) < 0) {
				x = x.getRight();
			} 
			else {
				return x;
			}
		}
		return null;
	}
	
	public void rotationToLeft(DennNode<K, V> x) {
		DennNode<K, V> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != nil) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == nil) {
			root = y;
		} 
		else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
		x.updateHeight();
		y.updateHeight();
	}
	
	public void rotationToRight(DennNode<K, V> x) {
		DennNode<K, V> y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != nil) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if (x.getParent() == nil) {
			root = y;
		} else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		y.setRight(x);
		x.setParent(y);
		x.updateHeight();
		y.updateHeight();
	}
	
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}
	
	public DennNode<K, V> successor(DennNode<K,V> x) {
		if(x.getRight() != nil) {
			return min(x.getRight());
		}
		
		DennNode<K,V> temp=x.getParent();
		
		while(temp != nil && x == temp.getRight()) {
			x = temp;
			temp = temp.getParent();
		}
		return temp;
	}
	
	public DennNode<K, V> min(DennNode<K, V> d) {
		DennNode<K,V> temp = d;
		while(temp.getLeft() != nil) {
			temp = temp.getLeft();
		}
		return temp;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DennNode[] deleteNode(DennNode<K, V> z) {
		DennNode<K,V> y = nil;
		if (z.getRight() == nil || z.getLeft() == nil) {
			y = z;
		}
		else{
			y = successor(z);
		}
		
		DennNode<K,V> x=nil;
		
		if(y.getLeft()!=nil) {
			x = y.getLeft();
		}
		
		else {
			x = y.getRight();
		}
		
		if( x != null) {
			x.setParent(y.getParent());	
		}
		
		if(y.getParent()==nil) {
			root=x;
		}
		else {
			if(y == y.getParent().getLeft()) {
				y.getParent().setLeft(x);
			}
			else {
				y.getParent().setRight(x);
			}
		}
		
		if(nil == null && x == null) {
			x = y.getParent();
		}
		
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
		
		DennNode<K,V>[]ans = new DennNode[2];
		
		ans[0] = x;
		ans[1] = y;
		return ans;
	}
	
}
