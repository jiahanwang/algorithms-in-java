package org.java.algorithm.graph.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.java.algorithm.graph.basics.SimpleDirectedGraph;
import org.junit.Before;
import org.junit.Test;

public class SimpleDirectedGraphTest {
	
	SimpleDirectedGraph<String, String> graph;

	@Before
	public void setUp() throws Exception {
		graph = new SimpleDirectedGraph<String, String>();
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
		assertTrue("Add a edge with one vertex existing", graph.addEdge("edge4-9", "4", "9"));
		assertTrue("Add a edge with both vertices existing", graph.addEdge("edge5-6", "5", "6"));
		assertTrue("Add a reversed edge with both vertices existing", graph.addEdge("edge2-1", "2", "1"));
		assertFalse("Add a edge whose identity existed", graph.addEdge("edge1-2", "4", "5"));
		assertFalse("Add a edge with both vertices existing but a multiple edge", graph.addEdge("edge1-2-2", "1", "2"));
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
	public void testGetVertices() {
		Collection<String> vertices = new LinkedList<String>(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
		assertTrue("Get all vertices", graph.getVertices().containsAll(vertices) && vertices.containsAll(graph.getVertices()));
	}

	@Test
	public void testGetEdges() {
		Collection<String> edges = new LinkedList<String>(Arrays.asList(new String[]{"edge1-2", "edge1-3", "edge2-3", "edge3-4"}));
		assertTrue("Get all edges", graph.getEdges().containsAll(edges) && edges.containsAll(graph.getEdges()));
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
	public void testAdjacentVertices() {
		Collection<String> adjacentVertices = new LinkedList<String>(Arrays.asList(new String[]{"4"}));
		assertTrue("Get adjacent vertices", graph.adjacentVertices("3").containsAll(adjacentVertices) && adjacentVertices.containsAll(graph.adjacentVertices("3")));
		assertNull("Vertex doesn't exist", graph.adjacentVertices("7"));
	}

	@Test
	public void testIncidentEdges() {
		Collection<String> incidentEdges = new LinkedList<String>(Arrays.asList(new String[]{"edge2-3", "edge1-3", "edge3-4"}));
		assertTrue("Get incident edges", graph.incidentEdges("3").containsAll(incidentEdges) && incidentEdges.containsAll(graph.incidentEdges("3")));
		assertNull("Vertex doesn't exist", graph.incidentEdges("7"));
	}

	@Test
	public void testIsAdjacent() {		
		assertFalse("Both vertices don't exist", graph.isAdjacent("7", "8"));
		assertFalse("One vertex doesn't exist", graph.isAdjacent("1", "7"));
		assertFalse("1 is not adjacent to 2", graph.isAdjacent("1", "2"));
		assertTrue("2 is adjacent to 2", graph.isAdjacent("2", "1"));
	}

	@Test
	public void testAreAdjacent() {		
		assertFalse("Both vertices don't exist", graph.areAdjacent("7", "8"));
		assertFalse("One vertex doesn't exist", graph.areAdjacent("1", "7"));
		assertFalse("Vertices aren't adjacent", graph.areAdjacent("1", "2"));
		graph.addEdge("edge2-1", "2", "1");
		assertTrue("Vertices are adjacent", graph.areAdjacent("1", "2"));
	}

	@Test
	public void testAreIncident() {
		assertFalse("Edge doesn't exist", graph.areAdjacent("1", "edge5-6"));
		assertFalse("Vertex doesn't exist", graph.areAdjacent("7", "edge1-2"));
		assertFalse("Both vertex and edge don't exist", graph.areAdjacent("7", "edge7-8"));
		assertFalse("Vertex and edge aren't incident", graph.areIncident("1", "edge2-3"));
		assertTrue("Vertex and incoming edge are incident", graph.areIncident("3","edge1-3"));
		assertTrue("Vertex and outgoing edge are incident", graph.areIncident("3","edge3-4"));
	}

	@Test
	public void testDestination() {
		assertEquals("Get the right destination", graph.destination("edge1-2"), "2");
		assertEquals("Edge doesn't exist", graph.destination("edge1-7"), null);
	}

	@Test
	public void testSource() {
		assertEquals("Get the right source", graph.source("edge1-2"), "1");
		assertEquals("Edge doesn't exist", graph.source("edge1-7"), null);
	}

	@Test
	public void testInDegree() {
		assertEquals("Get the right indegree", graph.inDegree("3"), 2);
		assertEquals("Vertex doesn't exist", graph.inDegree("8"), -1);
	}

	@Test
	public void testOutDegree() {
		assertEquals("Get the right outdegree", graph.outDegree("3"), 1);
		assertEquals("Vertex doesn't exist", graph.outDegree("8"), -1);
	}

	@Test
	public void testIncomingVertices() {
		Collection<String> incomingVertices = new LinkedList<String>(Arrays.asList(new String[]{"1", "2"}));
		assertTrue("Get incoming vertices", graph.incomingVertices("3").containsAll(incomingVertices) && incomingVertices.containsAll(graph.incomingVertices("3")));
		assertNull("Vertex doesn't exist", graph.incomingVertices("7"));
	}

	@Test
	public void testOutgoingVertices() {
		Collection<String> outgoingVertices = new LinkedList<String>(Arrays.asList(new String[]{"2", "3"}));
		assertTrue("Get outgoing vertices", graph.outgoingVertices("1").containsAll(outgoingVertices) && outgoingVertices.containsAll(graph.outgoingVertices("1")));
		assertNull("Vertex doesn't exist", graph.outgoingVertices("7"));
	}

	@Test
	public void testIncomingEdges() {
		Collection<String> incomingEdges = new LinkedList<String>(Arrays.asList(new String[]{"edge2-3", "edge1-3"}));
		assertTrue("Get incident edges", graph.incomingEdges("3").containsAll(incomingEdges) && incomingEdges.containsAll(graph.incomingEdges("3")));
		assertNull("Vertex doesn't exist", graph.incomingEdges("7"));
	}

	@Test
	public void testOutgoingEdges() {
		Collection<String> outgoingEdges = new LinkedList<String>(Arrays.asList(new String[]{"edge1-2", "edge1-3"}));
		assertTrue("Get adjacent vertices", graph.outgoingEdges("1").containsAll(outgoingEdges) && outgoingEdges.containsAll(graph.outgoingEdges("1")));
		assertNull("Vertex doesn't exist", graph.incidentEdges("7"));
	}

	@Test
	public void testRevert() {
		assertTrue("Revert an edge", graph.revert("edge3-4"));
		assertFalse("Edge doesn't exist", graph.revert("edge1-8"));
	}

	@Test
	public void testRevertAll() {
		assertTrue("Revert all", graph.revertAll());
		
	}

	@Test
	public void testRemoveAllEdges() {
		assertTrue("Remove three edges including one that doesn't exist", graph.removeAllEdges(Arrays.asList(new String[]{"edge1-2", "edge2-3", "edge7-8"})));
	}

	@Test
	public void testRemoveAllVertices() {
		assertTrue("Remove three vertives including one that doesn't exist", graph.removeAllVertices(Arrays.asList(new String[]{"1", "4", "7"})));
	}
	
	@Test
	public void testToString() {
		System.out.println(graph);
	}

}
