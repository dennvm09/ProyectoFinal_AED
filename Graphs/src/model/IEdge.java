package model;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEdge<E> extends INode<E>{

	ArrayList<IEdge<E>> getAdjacents();
	HashMap<IEdge<E>, Double> getDistances();
	void addAdjacents(IEdge<E> n);
	void addDistance(IEdge<E> adjacent, Double distance);
	
}
