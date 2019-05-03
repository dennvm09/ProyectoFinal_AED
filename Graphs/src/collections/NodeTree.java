package collections;

import java.util.ArrayList;

public class NodeTree<T> {

	private T elem;
	private String key;
	private ArrayList<NodeTree<T>> childs;
	private NodeTree<T> parent;
	
	
	public NodeTree(T elem) {
		this.elem = elem;
		childs = new ArrayList<NodeTree<T>>();
	}
	
	public void addChild(NodeTree<T> child) {
		childs.add(child);
	}


	public T getElem() {
		return elem;
	}


	
	public void setElem(T elem) {
		this.elem = elem;
	}


	
	public ArrayList<NodeTree<T>> getChilds() {
		return childs;
	}


	public void setChilds(ArrayList<NodeTree<T>> childs) {
		this.childs = childs;
	}



	public NodeTree<T> getParent() {
		return parent;
	}


	public void setParent(NodeTree<T> parent) {
		this.parent = parent;
	}
	
	
	
}
