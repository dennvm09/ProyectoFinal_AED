package collections;

public abstract class Node<E> implements INode<E> {

	private boolean visit;
	private E elem;
	private Node<E> parent;
	
	public Node(E elem) {
		this.elem = elem;
		visit = false;
		parent = null;
	}
	
	@Override
	public boolean isVisit() {
		return visit;
	}
	
	@Override
	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	@Override
	public Node<E> getParent() {
		return parent;
	}

	@Override
	public void setParent(Node<E> parent) {
		this.parent = parent;
		
	}

	@Override
	public E getElem() {
		return elem;
	}

	@Override
	public void setElem(E elem) {
		this.elem = elem;
		
	}
	

	
}
