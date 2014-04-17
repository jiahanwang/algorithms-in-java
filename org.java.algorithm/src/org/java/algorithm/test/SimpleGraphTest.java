package org.java.algorithm.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import org.java.algorithm.graph.SimpleGraph;
import org.junit.Before;
import org.junit.Test;

public class SimpleGraphTest {
	
	private SimpleGraph<String, String> graph;

	@Before
	public void setUp() throws Exception {
		graph = new SimpleGraph<String, String>();
		graph.addEdge("edge1-2", "1", "2");
		graph.addEdge("edge1-3", "1", "3");
		graph.addEdge("edge2-3", "2", "3");
		graph.addEdge("edge3-4", "3", "4");
		graph.addVertex("5");
		graph.addVertex("6");
	}

	@Test
	public void testAddEdge() {
		assertTrue("Add a edge with no vertices existing", graph.addEdge("edge7-8", "7", "8"));
		assertTrue("Add a edge with one vertex existing", graph.addEdge("edge497", "4", "9"));
		assertTrue("Add a edge with both vertices existing", graph.addEdge("edge5-6", "5", "6"));
		assertFalse("Add a edge whose identity existed", graph.addEdge("edge1-2", "4", "5"));
		assertFalse("Add a edge with both vertices existing but a multiple edge)", graph.addEdge("edge1-2-2", "1", "2"));
		assertFalse("Add a self loop", graph.addEdge("edge3-3", "3", "3"));	
	}

	@Test
	public void testAddVertex() {
		assertTrue("Add a vertex", graph.addVertex("7"));
		assertFalse("Add a vertex whose identity already existed", graph.addVertex("1"));
	}

	@Test
	public void testRemoveEdge() {
		assertTrue("Remove a edge", graph.removeEdge("edge1-2"));
		assertFalse("Remove a edge that doesn't exist", graph.removeEdge("edge1-7"));
	}

	@Test
	public void testRemoveVertex() {
		assertTrue("Remove a vertex", graph.removeVertex("1"));
		assertFalse("Remove a vertex that doesn't exist", graph.removeVertex("7"));
	}

	@Test
	public void testNumOfVertices() {
		assertEquals("Number of vertices", graph.numOfVertices(), 6);
	}

	@Test
	public void testNumOfEdges() {
		assertEquals("Number of edges", graph.numOfEdges(), 4);
	}

	@Test
	public void testContainsVertex() {
		assertTrue("Contains an existing vertex", graph.containsVertex("1"));
		assertFalse("Contains a not existing vertex", graph.containsVertex("8"));
	}

	@Test
	public void testContainsEdge() {
		assertTrue("Contains an existing edge", graph.containsEdge("edge1-2"));
		assertFalse("Contains a not existing edge", graph.containsEdge("edge4-9"));
	}

	@Test
	public void testGetVertices() {
		Collection<String> vertices = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
		assertTrue("Get all vertices", graph.getVertices().containsAll(vertices));
	}

	@Test
	public void testGetEdges() {
		Collection<String> edges = new LinkedList<String>(Arrays.asList(new String[]{"edge1-2", "edge1-3", "edge2-3", "edge3-4"}));
		assertTrue("Get all edges", graph.getEdges().containsAll(edges));
	}

	@Test
	public void testAdjacentVertices() {
		Collection<String> adjacentVertices = new LinkedList<String>(Arrays.asList(new String[]{"2", "3"}));
		assertTrue("Get adjacent vertices", graph.adjacentVertices("1").containsAll(adjacentVertices));
		assertNull("Vertex doesn't exist", graph.adjacentVertices("7"));
	}

	@Test
	public void testIncidentEdges() {
		Collection<String> incidentEdges = new LinkedList<String>(Arrays.asList(new String[]{"edge1-2", "edge1-3"}));
		assertTrue("Get adjacent vertices", graph.incidentEdges("1").containsAll(incidentEdges));
		assertNull("Vertex doesn't exist", graph.incidentEdges("7"));
	}

	@Test
	public void testAreAdjacent() {
		assertFalse("Both vertices don't exist", graph.areAdjacent("7", "8"));
		assertFalse("One vertex doesn't exist", graph.areAdjacent("1", "7"));
		assertTrue("Vertices are adjacent", graph.areAdjacent("1", "2"));
		assertFalse("Vertices aren't adjacent", graph.areAdjacent("1", "5"));
	}

	@Test
	public void testAreIncident() {
		assertFalse("Edge doesn't exist", graph.areAdjacent("1", "edge5-6"));
		assertFalse("Vertex doesn't exist", graph.areAdjacent("7", "edge1-2"));
		assertFalse("Both vertex and edge don't exist", graph.areAdjacent("7", "edge7-8"));
		assertFalse("Vertex and edge aren't incident", graph.areIncident("1", "edge2-3"));
		assertTrue("Vertex and edge are incident", graph.areIncident("1","edge1-2"));
	}

	@Test
	public void testEndVertices() {
		assertNull("Edge doesn't exist", graph.endVertices("edge7-8"));
		assertTrue("Get both end vertices", graph.endVertices("edge1-2").containsAll(Arrays.asList(new String[]{"1", "2"})));
	}

	@Test
	public void testOpposite() {
		assertNull("Edge doesn't exist", graph.opposite("edge1-7", "1"));
		assertNull("Vertex doesn't exist", graph.opposite("edge1-2", "7"));
		assertTrue("Get the opposite", graph.opposite("edge1-2", "1").equals("2"));
		assertTrue("Get the opposite", graph.opposite("edge1-2", "2").equals("1"));
	}

	@Test
	public void testDegree() {
		assertEquals("Get the right degree", graph.degree("1"), 2);
		assertEquals("Vertex doesn't exist", graph.degree("7"), -1);
	}

	@Test
	public void testToString() {
		System.out.println(graph);
	}

	@Test
	public void testRemoveAllEdgs() {
		assertTrue("Remove three edges including one that doesn't exist", graph.removeAllEdgs(Arrays.asList(new String[]{"edge1-2", "edge2-3", "edge7-8"})));
		System.out.println(graph);
	}

	@Test
	public void testRemoveAllVertices() {
		assertTrue("Remove three vertives including one that doesn't exist", graph.removeAllVertices(Arrays.asList(new String[]{"1", "4", "7"})));
		System.out.println(graph);
	}

}
