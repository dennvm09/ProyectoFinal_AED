package trees;

public class RedBlackBSTNode<T extends Comparable<T>> extends TreeBinarySearchNode<T> {

	private boolean isBlack;
	private boolean isNull;

	public RedBlackBSTNode() {
		super();
		this.isBlack = true;
		this.isNull = true;

		sonLeft = null;
		sonRight = null;
	}

	public RedBlackBSTNode(T d) {
		super(d);
		this.isBlack = false;
		this.isNull = false;

		sonLeft = new RedBlackBSTNode<T>();
		this.setSonLeft(sonLeft);

		sonRight = new RedBlackBSTNode<T>();
		this.setSonRigth(sonRight);
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack() {
		  isBlack = true;
	}
	
	public boolean isRed() {
        return !isBlack;
    }

    public void setRed() {
        isBlack = false;
    }

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}

	public RedBlackBSTNode<T> getSonLeft() {
		return (RedBlackBSTNode<T>) super.getSonLeft();
	}

	public RedBlackBSTNode<T> getSonRight() {
		return (RedBlackBSTNode<T>) super.getSonRight();
	}

	public RedBlackBSTNode<T> getParent() {
		return (RedBlackBSTNode<T>) super.getParent();
	}

	public RedBlackBSTNode<T> getGrandParent() {
		return this.getParent().getParent();
	}

	public boolean isParentLeftChild() {
		return this.getParent() == this.getGrandParent().getSonLeft();
	}
	
	public boolean isLeftChild() {
        return (this == this.getParent().getSonLeft());
    }

    public boolean isRightChild() {
        return (this == this.getParent().getSonRight());
    }


	public boolean validateLeafNodesBlack() {
		if (isNull()) {
			return true;
		} else if (getSonLeft() == null && getSonRight() == null) {
			return false;
		}

		else {
			return getSonLeft().validateLeafNodesBlack() && getSonRight().validateLeafNodesBlack();
		}

	}
	
	public boolean validateRedHasBlackChildren() {
    	if (isNull()) {
    		return true;
    	}
    	else if(isRed()) {
    		if(getSonRight().isRed() || getSonLeft().isRed()) {
    			return false;
    		}	
    	}
    		return getSonLeft().validateRedHasBlackChildren() && getSonRight().validateRedHasBlackChildren();
    }
	
	
	public int validateBlackHeight() {
    	//base case: if the node is null, return 0
    	if (isNull()) {
    		return 0;
    	}
    	else {
    		
    		int leftsub= getSonLeft().validateBlackHeight();
    		int rightsub= getSonRight().validateBlackHeight();
    		
    		if(leftsub==-1 || rightsub==-1 && getSonLeft() != getSonRight()) {
    			return -1;
    		}

    		else{
    			
    			if(getSonLeft().isRed()) {
    				return leftsub;
    			}
    			else {
    				return leftsub= leftsub+1;
    			}
    		}
    	}     		

    }
    
	public RedBlackBSTNode<T> getUncle() {
        if( isParentLeftChild() ) {
            return this.getGrandParent().getSonRight();
        } else {
            return this.getGrandParent().getSonLeft();
        }
    }
	
	public String toString() {
        if(isNull()) {
            return "Node: isNull";
        } else {
            if( isRed() )
                return "Node: R " + getData().toString();
            else
                return "Node: B " + getData().toString();
        }
    }
	
}
