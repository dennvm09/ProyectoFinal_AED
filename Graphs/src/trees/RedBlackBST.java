package trees;

public class RedBlackBST<T extends Comparable<T>> extends TreesBinarySearch<T> {

	RedBlackBSTNode<T> nil = new RedBlackBSTNode<T>();
	private RedBlackBSTNode<T> root;

	public RedBlackBST() {
		super();
		root = new RedBlackBSTNode<T>();
		root = nil;
	}

	public RedBlackBST(RedBlackBSTNode<T> d) {
		super();
		// n.setData(data);
		root = d;
		nil = null;
		// root.parent=nil;

	}

	public void left_rotate(RedBlackBSTNode<T> x) {

		// y set as x's right child
		RedBlackBSTNode<T> y = x.getSonRight();

		// set's x as y's left child
		x.setSonRigth(y.getSonLeft());

		// if y's left child is not null
		if (y.getSonLeft() != null) {
			y.getSonLeft().setParent(x);
			;
		}
		y.setParent(x.getParent());

		// if x doesn't have a parent make y the root
		if (x.getParent().getData() == null) {
			root = y;
		}

		// if x is it's parent's left child then set y as the left child
		else if (x == x.getParent().getSonLeft()) {
			x.getParent().setSonLeft(y);
		}

		// otherwise set y as x's parent's right child
		else {
			x.getParent().setSonRigth(y);
		}

		y.setSonLeft(x);
		x.setParent(y);
	}

	public void right_rotate(RedBlackBSTNode<T> x) {
		// set y as x's left child
		RedBlackBSTNode<T> y = x.getSonLeft();
		// y's right child is set to x's left
		x.setSonLeft(y.getSonRight());

		// if y's left child is not null
		if (y.getSonLeft() != null) {
			y.getSonRight().setParent(x);
		}
		// sets x's parent as y's parent
		y.setParent(x.getParent());

		// if x doesn't have a parent make y the root
		if (x.getParent().getData() == null) {
			root = y;
		}

		// if x is it's parent's right child then set y as the right child
		else if (x == x.getParent().getSonRight()) {
			x.getParent().setSonRigth(y);
		}

		// otherwise set y as x's parent's left child
		else {
			x.getParent().setSonLeft(y);
		}

		y.setSonRigth(x);
		x.setParent(y);

	}

	public void insert(RedBlackBSTNode<T> z) {

		// creates new nil and root nodes
		RedBlackBSTNode<T> y = nil;
		RedBlackBSTNode<T> x = (RedBlackBSTNode<T>) root;

		// System.out.println("z"+ z.getData());
		// System.out.println("x"+ x.getData());

		while (!(x.isNull())) {
			// set y to x and if z is less than x's value then set x as x's left child
			// otherwise, if z is greater than x set as x's right child
			y = x;

			if (z.getData().compareTo(x.getData()) < 0) {
				x = x.getSonLeft();
			} else {
				x = x.getSonRight();
			}
		}

		z.setParent(y);

		// if y is null then set root as z
		if (y.isNull()) {
			root = z;
		}

		// if z is smaller than y then set it to y's left child
		else if (z.getData().compareTo(y.getData()) < 0) {
			y.setSonLeft(z);
		} else {
			// otherwise set it to y's right child
			y.setSonRigth(z);
			;
		}
		// creates leaf nodes and sets the color to red
		z.setSonLeft(nil);
		z.setSonRigth(nil);
		z.setRed();
		this.fixup(z);
	}

	/**
	 * inserts value into the node
	 * 
	 * @param n
	 */
	public void insert(T n) {
		// System.out.println("root"+ root.getData());
		insert(new RedBlackBSTNode<T>(n));
	}

	/**
	 * fix up reorders the tree if any rule of red black trees is broken
	 * 
	 * @param z
	 */
	public void fixup(RedBlackBSTNode z) {

		// creates a new node called y
		RedBlackBSTNode y = new RedBlackBSTNode();

		// System.out.println("parent:" + z.getParent());

		// as long as z's parent is red
		while (z.getParent().isRed()) {

			// if z is the left child of it's grandparent then make y why the grandparent's
			// right child

			if (z.getParent() == z.getGrandParent().getSonLeft()) {
				y = z.getGrandParent().getSonRight();

				// if y is red then set z's parent as black and set y as black and set z's
				// grandparent
				// to red and z's grandparent to z
				// CASE 1
				if (y.isRed()) {
					z.getParent().setBlack();
					y.setBlack();
					z.getGrandParent().setRed();
					z = z.getGrandParent();
				}
				// if z is it's parents right child then set z as z's parent and left rotate
				// CASE 2
				else if (z == z.getParent().getSonRight()) {
					z = z.getParent();
					left_rotate(z);
				}
				// set z's parent to black, set z's grandparent as red and red rotate
				// CASE 3
				else {
					z.getParent().setBlack();
					z.getGrandParent().setRed();
					right_rotate(z.getGrandParent());
				}

			} else {
				// set z's grandparent's left child to y
				y = z.getGrandParent().getSonLeft();

				// CASE 4
				if (y.isRed()) {
					z.getParent().setBlack();
					y.setBlack();
					z.getGrandParent().setRed();
					z = z.getGrandParent();
				}
				// CASE 5
				else if (z == z.getParent().getSonLeft()) {
					z = z.getParent();
					right_rotate(z);
				} else {
					// CASE 6
					z.getParent().setBlack();
					z.getGrandParent().setRed();
					left_rotate(z.getGrandParent());
				}
			}
		}
		// set root as black
		root.setBlack();
	}

	public RedBlackBSTNode<T> getRoot() {

		return (RedBlackBSTNode<T>) this.root;
	}

	public boolean validateLeafNodesBlack() {

		return getRoot().validateLeafNodesBlack();
	}

	public boolean validateRedHasBlackChildren() {

		return getRoot().validateRedHasBlackChildren();
	}

	public boolean validateBlackHeight() {

		return (getRoot().validateBlackHeight() >= 0);
	}

	public boolean validateRootNodeBlack() {

		return getRoot().isBlack();
	}

	public boolean validate() {
		return (this.validateRedHasBlackChildren() && this.validateBlackHeight() && this.validateLeafNodesBlack()
				&& this.validateRootNodeBlack());
	}

	/**
	 * inorder traversal of red black tree
	 * 
	 * @param node
	 */
	public void inOrder(RedBlackBSTNode<T> node) {
		if (node != null) {
			inOrder(node.getSonLeft());
			System.out.println(node.toString());
			inOrder(node.getSonRight());
		}
	}
	
	
	//Delete
	
	public RedBlackBSTNode<T> remove(T key) {
		
		RedBlackBSTNode<T> p = new RedBlackBSTNode<T>(key);
        if (p == null)
            return null;

        deleteNode(p);
        return p;
    }
	
	private void deleteNode(RedBlackBSTNode<T> p) {
        // If strictly internal, copy successor's element to p and then make p
        // point to successor.
        if (p.getSonLeft() != null && p.getSonRight() != null) {
        	RedBlackBSTNode<T> s = (RedBlackBSTNode<T>)successor(p);                              
            p.setData(s.getData());                                              
            p = s;                                                           
        } // p has 2 children                                               
        //                                                                    
        // Start fixup at replacement node, if it exists.                    
        RedBlackBSTNode<T> replacement = (p.getSonLeft() != null ? p.getSonLeft(): p.getSonRight());        
        if (replacement != null) {                                           
            // Link replacement to parent                                   
            replacement.parent = p.parent;                                   
            if (p.parent == null)                                            
                root = replacement;                                           
            else if (p == p.parent.getSonLeft())                                   
                p.parent.setSonLeft(replacement);                               
            else                                                             
                p.parent.setSonRigth(replacement);                   
            //                                                                
            // Null out links so they are OK to use by fixAfterDeletion.      
            //  p.left = p.right = p.parent = null;     
            p.setSonLeft(p.getSonRight().parent);//
            //                                                               
            // Fix replacement                                               
            if (p.isBlack()) {
            	 fixAfterDeletion(replacement);               
            }                                           
                         
        } else if (p.parent == null) { // return if we are the only node.    
            root = null;                                                      
        } else { //  No children. Use self as phantom replacement and unlink.
            if (p.isBlack()) {
            	 fixAfterDeletion(p);       
            }                                                                             

            if (p.parent != null) {
                if (p == p.parent.getSonLeft())
                    p.parent.setSonLeft(null);
                else if (p == p.parent.getSonRight())
                    p.parent.setSonRigth(null);
                p.parent = null;
            }
        }
    }
	
	private void fixAfterDeletion(RedBlackBSTNode<T> x) {
        while (x != root && x.isBlack()) {                                    
            if (x == x.getParent().getSonLeft()) {                                           
            	RedBlackBSTNode<T> sib = x.getParent().getSonRight();                                   
                // sibling is red                                                      
                if (sib.isRed()) {                                            
                    sib.setBlack();  
                    x.getParent().setRed();
                    
                    left_rotate(x.getParent());                       
                   
                    sib = x.getParent().getSonRight();                                    
                }                                                                     
                // sibling has two black children                                      
                if (sib.getSonLeft().isBlack()  && sib.getSonRight().isBlack()) { 
                    sib.setRed();                                           
                    x = x.getParent();                                              
                    //                                                                 
                } else {                                                              
                    if (sib.getSonLeft().isRed()) {                               
                    	sib.getSonLeft().setBlack();                                   
                        sib.setRed();                                       
                        right_rotate(sib);                                                       
                        sib = x.getParent().getSonRight();                               
                    }   
                    
                    if(x.getParent().isBlack()) {
                    	sib.setBlack();
                    }else {
                    	sib.isRed();
                    }
                                               
                    x.getParent().setBlack();
                   sib.getSonRight().isBlack();
                  left_rotate(x.getParent());
                               
                    x = root;                                                        
                }
            } else { // symmetric
            	RedBlackBSTNode<T> sib = x.getParent().getSonLeft();

                if (sib.isRed()) {
                	sib.setBlack();
                    x.getParent().setRed();
                   right_rotate(x.getParent());
                   sib = x.getParent().getSonLeft();
                   
                }

                if (sib.getSonRight().isBlack() && sib.getSonLeft().isBlack()) {
                    sib.isRed();
                	x = x.getParent();
                   
                } else {
                    if ( sib.getSonLeft().isBlack()) {
                    	sib.getSonRight().setBlack();
                        sib.setRed();
                        left_rotate(sib);
                       
                        sib = x.getParent().getSonLeft();
                    }
                    if(x.getParent().isBlack()){
                    		sib.setBlack();
                    }else {
                    	sib.setRed();
                    }
                    x.getParent().setBlack();
                    sib.getSonLeft().setBlack();
                    right_rotate(x.getParent());
          
                    x = root;
                }
            }
        }

        x.setBlack();
                                                        
    }
	
	public static void main(String[] args) {
		
		RedBlackBST<String> p = new RedBlackBST<>();
		
		p.insert("hola");
		p.insert("dos");
		p.insert("tres");
		System.out.println(p.getRoot().getData());
		//p.inOrder(p.getRoot());
		
		System.out.println(p.searchNode("hola", null));
		
	}

}
