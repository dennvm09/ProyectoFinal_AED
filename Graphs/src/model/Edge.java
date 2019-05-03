package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Edge<E> extends Node<E> implements IEdge<E>, Comparable<Edge<E>> {
	
	private ArrayList<IEdge<E>> adjacents;
	private HashMap<IEdge<E>, Double> distances;
	private double prevDistance;
	
	public Edge(E elem) {
		super(elem);
		adjacents = new ArrayList<IEdge<E>>();
		distances = new HashMap<>();
	}

	@Override
	public int compareTo(Edge<E> node) {
		
		if(prevDistance == node.prevDistance) {
			return 0;
		}
		else if(prevDistance < node.prevDistance) {
			return -1;
		}else {
			return 0;
		}
		
	}

	@Override
	public ArrayList<IEdge<E>> getAdjacents() {
		
		return adjacents;
	}

	@Override
	public HashMap<IEdge<E>, Double> getDistances() {
		
		return distances;
	}
	

	public double getPrevDistance() {
		return prevDistance;
	}

	public void setPrevDistance(double prevDistance) {
		this.prevDistance = prevDistance;
	}

	@Override
	public void addAdjacents(IEdge<E> n) {
		adjacents.add(n);
	}

	@Override
	public void addDistance(IEdge<E> adjacent, Double distance) {
		distances.put(adjacent, distance);	
	}
	
	public Double getDistanceAdjacent(IEdge<E> n) {
		return distances.get(n);
	}
	
	
}
