package model;

public interface INode<E> {

	public boolean isVisit();
	public void setVisit(boolean visit);
	public Node<E> getParent();
	public void setParent(Node<E> parent);
	public E getElem();
	public void setElem(E elem);
}
