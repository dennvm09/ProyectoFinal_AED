package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import collections.DisjointSets;
import collections.IEdge;
import collections.IGraph;
import collections.NodeAdyacentWeight;
import queue_Linny.*;
import stack_Linny.LinnyStack;


public class Graph<E> implements IGraph<E> {

	private HashMap<E, Edge<E>> nodes;
	
	private int maxNodes;
	private int totalNodes;
	
	public Graph(int maxNodes) {
		nodes = new HashMap<>();
		this.maxNodes = maxNodes;
		totalNodes = 0;
	}

	public HashMap<E, Edge<E>> getNodes() {
		return nodes;
	}

	public void setEdges(HashMap<E, Edge<E>> nodes) {
		this.nodes = nodes;
	}

	@Override
	public void addNode(E node) throws Exception {
		Edge<E> edg = new Edge<E>(node);
		
		if(nodes.get(node) != null) {
			throw new Exception("El elemento ya existe");
		}
		if (totalNodes == maxNodes) {
			throw new Exception("El numero maximo de elementos ha sido alcanzado");
		}
		
		nodes.put(node, edg);
		totalNodes++;
		
	}

	@Override
	public void addEdge(E node1, E node2, double distance) throws Exception {
		Edge<E> nodes1 = nodes.get(node1);
		Edge<E> nodes2 = nodes.get(node2);
		
		if(nodes2 == null || nodes1 == null) {
			throw new Exception("Uno de los Elementos no existe");
		}
		nodes1.addAdjacents(nodes2);
		nodes1.addDistance(nodes2, distance);
		
	}

	@Override
	public int BFS(E Norigin) throws Exception {
		
		for (E nd : nodes.keySet()) {
			nodes.get(nd).setVisit(false);
		}
		int find = 0;
		Edge<E> actv = nodes.get(Norigin);
		
		if(actv == null) {
			throw new Exception("El elemento existe");
		}
		
		Queue<Edge<E>> queueG = (Queue<Edge<E>>) new LinnyQueue<Edge<E>>();
		queueG.offer(actv);
		find++;
		actv.setVisit(true);
		while(!queueG.isEmpty()) {
			
			Edge<E> f = queueG.poll();
			ArrayList<IEdge<E>> adjacents = f.getAdjacents();
			for (int i = 0; i < adjacents.size(); i++) {
				if(!adjacents.get(i).isVisit()) {
					adjacents.get(i).setVisit(true);
					find++;
					adjacents.get(i).setParent(f);
					queueG.offer((Edge<E>)adjacents.get(i));
				}	
			}
			f.setVisit(true);
			
		}
		
		return find;
	}

	@Override
	public int BFS() {
		
		int bfs;
		Set<E> keys = nodes.keySet();
		try {
			bfs = BFS(keys.iterator().next());
		}catch(Exception s) {
			bfs = 0;
		}
		
		return bfs;
	}

	@Override
	public void DFS() throws Exception {
		for(E actual : nodes.keySet()) {
			nodes.get(actual).setVisit(true);
		}
		
		for(E f: nodes.keySet()) {
			Edge<E> actv = nodes.get(f);
			if(!actv.isVisit()) {
				LinnyStack<Edge<E>> stackS = new LinnyStack<Edge<E>>();
				stackS.linnyPush(actv);
				while(!stackS.isEmpty()) {
					Edge<E> actual = stackS.linnyPop();
					if(!actual.isVisit()) {
						actual.setVisit(true);
						ArrayList<IEdge<E>> adjacents = actual.getAdjacents();
						for(int i = 0; i < adjacents.size(); i++) {
							Edge<E> add = (Edge<E>) adjacents.get(i);
							if(!add.isVisit()) {
								stackS.linnyPush(add);
								add.setParent(actual);
							}
						}
					}
				}
			}
		}
		
	}

	@Override
	public IGraph<E> prim() throws Exception {
		
		int cant = nodes.size();
		int cantReal = BFS();
		if(cant != cantReal)
			throw new Exception("Grafo no conexo");
		PriorityQueue<NodeAdyacentWeight<Edge<E>>> queue = new PriorityQueue<>();
		Graph<E> r = new Graph<E>(maxNodes);
		HashMap<E, Edge<E>> newNodes = new HashMap<>();
		for(E na : nodes.keySet()) {
			Edge<E> actual = nodes.get(na);
			E elemActual = actual.getElem();
			actual.setVisit(false);
			r.addNode(elemActual);
			Edge<E> n = r.getNode(elemActual);
			newNodes.put(elemActual, n);
			ArrayList<IEdge<E>> adjacents = actual.getAdjacents();
			for(int i = 0; i < adjacents.size(); i++) {
				queue.add(new NodeAdyacentWeight<Edge<E>>(actual,actual.getDistanceAdjacent((Edge<E>)adjacents.get(i)), (Edge<E>)adjacents.get(i)));
				
			}	
		}
		
		NodeAdyacentWeight<Edge<E>> lowEdge = queue.poll();
		Edge<E> actual = lowEdge.getNode();
		queue = new PriorityQueue<>();
		queue.add(lowEdge);
		
		
		while(!queue.isEmpty()) {
			actual.setVisit(true);
			ArrayList<IEdge<E>> adjacents =actual.getAdjacents();
			for(int i = 0 ; i < adjacents.size(); i++) {
				Edge<E>  adjcentActual= (Edge<E>) adjacents.get(i);
				if(!adjcentActual.isVisit()) {
					NodeAdyacentWeight<Edge<E>> newEdge=  new NodeAdyacentWeight<Edge<E>>(actual, actual.getDistanceAdjacent(adjcentActual), adjcentActual);
					queue.add(newEdge);
				}
				
			}
			
			
			boolean add = false;
			while(!add && queue.isEmpty()) {
				NodeAdyacentWeight<Edge<E>> nextEdge = queue.poll();
				if(!nextEdge.getAdjacent().isVisit()) {
					r.addEdge(nextEdge.getNode().getElem(), nextEdge.getAdjacent().getElem(), nextEdge.getDistance());
					add = true;
					actual = nextEdge.getAdjacent();
				}
			}
		
		}

		return r;
	}
	
	public Edge<E> getNode(E elem){
		return nodes.get(elem);
	}

	@Override
	public Graph<E> Kruskal() throws Exception {
		Graph<E> gOut = new  Graph<E>(maxNodes);
		DisjointSets set = new DisjointSets(maxNodes);
		
		for(int i = 0; i < totalNodes; i++) {
			try {
				gOut.addNode(nodes.get(i).getElem());
				nodes.get(i).setVisit(false);
			}catch(Exception e){
				
				e.printStackTrace();
			}
		}
		
		ArrayList<NodeAdyacentWeight<Edge<E>>> edges = new ArrayList<>();
		
		for(E key : nodes.keySet()) {
			Edge<E> actual = new Edge<>(key);
		}
		
		
		Collections.sort(edges);
		
		for(int k = 0; k < edges.size(); k++) {
			NodeAdyacentWeight<Edge<E>> edge = edges.get(k);
			Edge<E> i = edge.getNode();
			Edge<E> J = edge.getAdjacent();
		}
		return gOut;
		
	}

	@Override
	public ListWeight<E> Dijkstra(E node1, E node2) throws Exception {
		
		HashMap<Edge<E>, Double> l = new HashMap<>();
		HashMap<Edge<E>, Double> s = new HashMap<>();
		
		for(E na : nodes.keySet()) {
			l.put(nodes.get(na), Double.MAX_VALUE);
		}
		
		Edge<E> n1 = nodes.get(node1);
		Edge<E>  n2 = nodes.get(node2);
		if(n1 == null || n2 == null) {
			throw new Exception("Uno de los nodos no existe");
		}
		l.put(n1, 0.0);
		PriorityQueue<Edge<E>> heap = new PriorityQueue<>();
		heap.add(n1);
		boolean find = false;
		while(s.get(n2) == null && !heap.isEmpty()) {
			Edge<E> actual = heap.poll();
			HashMap<IEdge<E>, Double> actualDistances = actual.getDistances();
			double lActual = l.get(actual);
			
			s.put(actual, 0.0);
			if(actual == n2){
				find = true;
			}
			
			ArrayList<IEdge<E>> adjacents = actual.getAdjacents();
			for(int i = 0; i < adjacents.size(); i++) {
				Edge<E> actualAdjacent = (Edge<E>) adjacents.get(i);
				Double newActualDistances = actualDistances.get(actualAdjacent);
				if(newActualDistances + lActual < l.get(actualAdjacent)) {
					actualAdjacent.setParent(actual);
					actualAdjacent.setPrevDistance(newActualDistances + lActual);
					l.put(actualAdjacent, newActualDistances + lActual);
					heap.add(actualAdjacent);
				}
			}
			
			
			
		}
		
		if(!find)
			throw new Exception("Imposible llegar del nodo 1 al nodo 2");
		LinkedList<E> path = new LinkedList<E>();
		Edge<E> actual = n2;
		while(actual != n1) {
			E elem = actual.getElem();
			path.addFirst(elem);
			actual = (Edge<E>) actual.getParent();
		}
		path.addFirst(n1.getElem());
		
		return new ListWeight<>(path, l.get(n2));
		
	}

	@Override
	public ArrayList<E> getAdjacents(E node) throws Exception {
		if(nodes.get(node)== null) {
			throw new Exception("Elemento no encontrado");
		}
		
		ArrayList<IEdge<E>> adjacents = nodes.get(node).getAdjacents();
		ArrayList<E> rl = new ArrayList<E>();
		for(int i = 0; i <adjacents.size(); i++) {
			rl.add(adjacents.get(i).getElem());
		}
		return rl;
	}

	@Override
	public E getParent(E node) throws Exception {
		
		return nodes.get(node).getParent().getElem();
	}

	@Override
	public void deleteNode(E node) throws Exception {
		Edge<E>  delete = nodes.get(node);
		if(delete == null)
			throw new Exception("Nodo no existe");
		for(E k : nodes.keySet()) {
			Edge<E> actual = nodes.get(k);
			actual.getAdjacents().remove(delete);
			actual.getDistances().remove(delete);
		}
		nodes.remove(node);
		
	}

	@Override
	public void deleteEdge(E node1, E node2) throws Exception {
		
		Edge<E> nodes1 = nodes.get(node1);
		Edge<E> nodes2 = nodes.get(node2);
		
		if(nodes1==null || nodes2==null||nodes1.getDistanceAdjacent(nodes2)==null )
			throw new Exception("Arista o nodo no existente");
		
		nodes1.getAdjacents().remove(nodes2);
		nodes1.getDistances().remove(nodes2);
		
	}

	@Override
	public double getDistance(E node1, E node2) throws Exception {
		
		Edge<E> nodes1 = nodes.get(node1);
		Edge<E> nodes2 = nodes.get(node2);
		if(nodes1 == null || nodes2 == null || nodes1.getDistanceAdjacent(nodes2) == null)
			throw new Exception("La arista o el elemento no existe");
		return nodes1.getDistances().get(nodes2);
	}
	
	
}
