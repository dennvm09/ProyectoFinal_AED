package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graph.*;

public class GraphTest {
	
	private Graph<String> graph;
	
	public void stage1() {
		graph = new Graph<>(4);	
	}
	
	@Test
	public void AddNodeTest() {
		stage1();
		for (int i = 0; i < 4; i++) {
			String m =  "re"+i;
			try {
				graph.addNode(m);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void BFSTest() throws Exception {
		stage1();
		int m = graph.BFS();
		assertTrue(m == 0);
	}
	
	@Test
	public void testAddEdge() {
		stage1();
		try {
			graph.addEdge("re0", "re6", 8);
		} catch (Exception e) {
			
		}
	}


}
