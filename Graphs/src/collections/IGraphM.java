package collections;
import graph.NodeM;

public interface IGraphM<T> {
	
	public void addNodeM(T key);
	public void addEdge(T key, T key2, double dis);
	public NodeM<T> searchNodeM(T key);
	public void deleteNodeM(T key);
	public void deleteEdge(T key, T key2);
	public boolean adjacentNodeM(T key, T key2);
	public double getDistance(T key, T key2);
	public int getPosN(T key);
}
