package org.java.algorithm.test;

import static org.junit.Assert.*;

import java.util.*;

import org.java.algorithm.graph.*;
import org.java.algorithm.traverse.BFSIterator;
import org.java.algorithm.traverse.DFSIterator;
import org.java.algorithm.traverse.Traverse;
import org.junit.Before;
import org.junit.Test;

public class UndirectedGraphTraverseTest {
	
	SimpleGraph<String, String> graph;
	MultiGraph<String, String> multiGraph;

	@Before
	public void setUp() throws Exception {
		graph = new SimpleGraph<String, String>();
		graph.addEdge("edge1-2", "1", "2");
		graph.addEdge("edge1-3", "1", "3");
		graph.addEdge("edge2-3", "2", "3");
		graph.addEdge("edge3-4", "3", "4");
		graph.addVertex("5");
		graph.addEdge("edge1-5", "1", "5");
		graph.addVertex("6");
		
		multiGraph = new MultiGraph<String, String>();
		multiGraph.addEdge("edge1-2", "1", "2");
		multiGraph.addEdge("edge1-2-2", "1", "2");
		multiGraph.addEdge("edge1-3", "1", "3");
		multiGraph.addEdge("edge2-3", "2", "3");
		multiGraph.addEdge("edge2-3-2", "2", "3");
		multiGraph.addEdge("edge3-4", "3", "4");
		multiGraph.addVertex("5");
		multiGraph.addEdge("edge1-5", "1", "5");
		multiGraph.addVertex("6");
	}

	@Test
	public void testSimpleGraphBfs() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5"}));
		assertEquals("SimpleGraph Bfs", Traverse.bfs(graph, "1", "5", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testSimpleGraphBfsWithoutComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5"}));
		assertEquals("SimpleGraph Bfs Without Comparator", Traverse.bfs(graph, "1", "5"), resultList);
	}

	@Test
	public void testSimpleGraphBfsWithoutDestinationAndComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5", "4"}));
		assertEquals("SimpleGraph Bfs Without Destination And Comparator", Traverse.bfs(graph, "1"), resultList);
	}

	@Test
	public void testSimpleGraphBfsWithoutDestination() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "2", "4"}));
		assertEquals("SimpleGraph Bfs Without Destination", Traverse.bfs(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return -a .compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testSimpleGraphDfs() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4"}));
		assertEquals("SimpleGraph DFS", Traverse.dfs(graph, "1", "4", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testSimpleGraphDfsWithoutComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4"}));
		assertEquals("SimpleGraph Dfs Without Comparator", Traverse.dfs(graph, "1", "4"), resultList);
	}

	@Test
	public void testSimpleGraphDfsWithoutDestinationAndComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		assertEquals("SimpleGraph Dfs Without Destination And Comparator", Traverse.dfs(graph, "1"), resultList);
	}

	@Test
	public void testSimpleGraphDfsWithoutDestination() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		assertEquals("SimpleGraph Dfs Without Destination", Traverse.dfs(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		}), resultList);
	}

	// multigraph test
	@Test
	public void testMultiGraphBfs() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "2"}));
		assertEquals("MultiGraph Bfs", Traverse.bfs(multiGraph, "1", "2", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testMultiGraphBfsWithoutComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5"}));
		assertEquals("MultiGraph Bfs Without Comparator", Traverse.bfs(multiGraph, "1", "5"), resultList);
	}

	@Test
	public void testMultiGraphBfsWithoutDestinationAndComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5", "4"}));
		assertEquals("MultiGraph Bfs Without Destination And Comparator", Traverse.bfs(multiGraph, "1"), resultList);
	}

	@Test
	public void testMultiGraphBfsWithoutDestination() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "2", "4"}));
		assertEquals("MultiGraph Bfs Without Destination", Traverse.bfs(multiGraph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testMultiGraphDfs() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4"}));
		assertEquals("MultiGraph DFS", Traverse.dfs(multiGraph, "1", "4", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		}), resultList);
	}

	@Test
	public void testMultiGraphDfsWithoutComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4"}));
		assertEquals("MultiGraph Dfs Without Comparator", Traverse.dfs(multiGraph, "1", "4"), resultList);
	}

	@Test
	public void testMultiGraphDfsWithoutDestinationAndComparator() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		assertEquals("MultiGraph Dfs Without Destination And Comparator", Traverse.dfs(multiGraph, "1"), resultList);
	}

	@Test
	public void testMultiGraphDfsWithoutDestination() {
		List<String> resultList = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		assertEquals("MultiGraph Dfs Without Destination", Traverse.dfs(multiGraph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		}), resultList);
	}
	
	@Test
	public void testSimpleGraphDFSIterator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(graph, "1", "3", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphDFSIteratorWithoutComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(graph, "1", "4");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphDFSIteratorWithoutDestinationAndComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(graph, "1");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphDFSIteratorWithoutDestination() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4", "5"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphDFSIterator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(multiGraph, "1", "4", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphDFSIteratorWithoutComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(multiGraph, "1", "4");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphDFSIteratorWithoutDestinationAndComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "4", "2"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(multiGraph, "1");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphDFSIteratorWithoutDestination() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4", "5"}));
		DFSIterator<String, String> iterator = new DFSIterator<String, String>(multiGraph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph DFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphBFSIterator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(graph, "1", "5", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphBFSIteratorWithoutComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(graph, "1", "5");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphBFSIteratorWithoutDestinationAndComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5", "4"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(graph, "1");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testSimpleGraphBFSIteratorWithoutDestination() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5", "4"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("SimpleGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphBFSIterator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "2"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(multiGraph, "1", "2", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphBFSIteratorWithoutComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(multiGraph, "1", "5");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphBFSIteratorWithoutDestinationAndComparator() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "5", "4"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(multiGraph, "1");
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph BFSIterator", actualResult, idealResult);
	}
	
	@Test
	public void testMultiGraphBFSIteratorWithoutDestination() {
		List<String> idealResult = new LinkedList<String>(Arrays.asList(new String[]{"1", "5", "3", "2", "4"}));
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(multiGraph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return - a.compareTo(b);
			}
		});
		List<String> actualResult = new LinkedList<String>();
		for(;iterator.hasNext();){
			actualResult.add(iterator.next());
		}
		assertEquals("MultiGraph BFSIterator", actualResult, idealResult);
	}

}
