package collections;

import java.util.ArrayList;

import graph.Graph;
import graph.ListWeight;

public interface IGraph<E> {

	public void addNode (E node) throws Exception;
	public void addEdge (E node1, E node2, double distance) throws Exception;
	public int BFS (E Norigin) throws Exception;
	public int BFS ();
	public void DFS() throws Exception;
	public IGraph<E> prim() throws Exception;
	public Graph<E> Kruskal() throws Exception;
	public ListWeight<E> Dijkstra  (E node1, E node2) throws Exception;
//	public double[][] FloydWarshall () throws Exception;
	public ArrayList <E> getAdjacents (E node) throws Exception;
	public E getParent (E node) throws Exception;
	public void deleteNode (E node) throws Exception;
	public void deleteEdge (E node1, E node2) throws Exception;
	public double getDistance (E node1, E node2) throws Exception;
	
}
