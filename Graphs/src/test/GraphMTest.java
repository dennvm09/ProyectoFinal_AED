package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collections.Tree;
import graph.*;

public class GraphMTest {

private GraphM<String> graph;
	
	public void stage1() throws Exception {
			graph = new GraphM<>(4);	
		
		for (int i = 0; i < 4; i++) {
			String m =  "re"+i;
			graph.addNodeM(m);
		}
	}
	
	@Test
	public void isEmptyTest() throws Exception {
		stage1();
		boolean is = graph.isEmpty();
		assertTrue(is == false);
	}

	@Test
	public void testAddNodeM() throws Exception {
		stage1();
		int limit = graph.getLimit();
		assertTrue(limit == 4);
	}
	
	@Test
	public void testSearchNodeM() throws Exception {	
		stage1();	
		NodeM<String> m =  graph.searchNodeM("re2");
		assertEquals(m.getElem(), "re2");	
	}
	
	
	@Test 
	public void testDeleteEdge() throws Exception {
		stage1();
		graph.deleteEdge("re3", "re4");
	}
	
	@Test
	public void testAdjacentNode() throws Exception {
		stage1();
		boolean m = 	graph.adjacentNodeM("re1", "re3");
		assertTrue( m == false);
	}
	
	@Test
	public void tesGetDistance() throws Exception {
		
		stage1();
		double m = graph.getDistance("re2", "re4");
		double m2 =  graph.getDistance("re2", "re4");
		assertTrue(m ==m2);
	}
	
	@Test
	public void testFloydWarshall() throws Exception {
		stage1();
		double[][] m =  graph.floydWarshall();
		double[][] g =  graph.floydWarshall();
		assertEquals(m, g);
	}
	
	@Test 
	public void testDijkstra() throws Exception {
		stage1();
		double[]  arr =  graph.dijkstra("re0");
		double[]  arr2 =  graph.dijkstra("re0");
		assertEquals(arr, arr2);
	}
	
	
	@Test 
	public void testBFs() throws Exception {
		stage1();
		Tree<String> m =  graph.BFS("re0");
		String root = m.getRoot().getElem();
		assertEquals(root, "re0");
	}
	
	@Test 
	public void testDFS() throws Exception  {
		stage1();
		ArrayList<String> m =  graph.DFS("re0");
		assertTrue(m.size() != 0);
		
	}
}
