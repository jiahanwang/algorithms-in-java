package org.java.algorithm.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.java.algorithm.graph.SimpleDirectedGraph;
import org.java.algorithm.traverse.Traverse;
import org.junit.Before;
import org.junit.Test;

public class TopologicalTest {
	
	SimpleDirectedGraph<String, String> graph;

	@Before
	public void setUp() throws Exception {
		graph = new SimpleDirectedGraph<String, String>();
		graph.addEdge("edge1-2", "1", "2");
		graph.addEdge("edge1-3", "1", "3");
		graph.addEdge("edge2-3", "2", "3");
		graph.addEdge("edge2-4", "2", "4");
		graph.addEdge("edge3-4", "3", "4");
		graph.addVertex("5");
		graph.addEdge("edge1-5", "1", "5");
		graph.addEdge("edge5-6", "5", "6");
		graph.addVertex("7");
		graph.addEdge("edge7-8", "7", "8");
	}

	@Test
	public void testTopologicalOrder() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}));
		List<String> actualResult = Traverse.topologicalOrder(graph, new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		});
		assertEquals("Topological Order", actualResult, idealResult);	
	}

	@Test
	public void testTopologicalOrderWithoutComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"7", "8", "1", "5", "6", "2", "3", "4"}));
		List<String> actualResult = Traverse.topologicalOrder(graph);
		assertEquals("Topological Order Without Comparator", actualResult, idealResult);
	}

}
