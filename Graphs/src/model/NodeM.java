package model;

import java.util.LinkedList;

public class NodeM<T> {
	
	private T elem;
	private int pos;
	private boolean visit;
	private LinkedList<NodeM<T>> adjacents;
	
	public NodeM(T elem) {
		this.elem = elem;
		adjacents = new LinkedList<NodeM<T>>();
		visit = true;
	}

	
	public T getElem() {
		return elem;
	}

	
	public void setElem(T elem) {
		this.elem = elem;
	}

	
	public int getPos() {
		return pos;
	}

	
	public void setPos(int pos) {
		this.pos = pos;
	}

	
	public boolean isVisit() {
		return visit;
	}


	public void setVisit(boolean visit) {
		this.visit = visit;
	}

	
	public LinkedList<NodeM<T>> getAdjacents() {
		return adjacents;
	}

	
	public void setAdjacents(LinkedList<NodeM<T>> adjacents) {
		this.adjacents = adjacents;
	}
	
	

}
