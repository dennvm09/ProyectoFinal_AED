package model;

public class NodeAdyacentWeight<E extends Node> implements Comparable<NodeAdyacentWeight<E>> {

	private E node;
	private double distance;
	private E adjacent;
	
	public NodeAdyacentWeight(E node, double distance, E adjacent) {
		this.node = node;
		this.distance = distance;
		this.adjacent = adjacent;
	}

	public E getNode() {
		return node;
	}

	public void setNode(E node) {
		this.node = node;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public E getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(E adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public int compareTo(NodeAdyacentWeight<E> o) {
		Double dis1 = distance;
		Double dis2 = o.distance;
		
		return dis1.compareTo(dis2);
	}
	
	
	
}
