package org.java.algorithm.graph;

public class Test {
	
	public static void main(String[] args){
		SimpleUndirectedGraph<String, String> graph = new SimpleUndirectedGraph<String, String>();
		graph.addEdge("edge1", "1", "2");
		graph.addEdge("edge2", "2", "3");
		graph.addVertex("3");
		System.out.println(graph);
		//System.out.println(graph.areAdjacent("1", "3"));
		//System.out.println(graph.areIncident("1", "edge2"));
		//System.out.println(graph.degree("2"));
		//System.out.println(graph.degree("edge3"));
		//System.out.println(graph.numOfEdges());
		//System.out.println(graph.numOfVertices());
		//System.out.println(graph.adjacentVertices("edge2"));
		//System.out.println(graph.adjacentVertices("edge3"));
		//System.out.println(graph.incidentEdges("2"));
		//System.out.println(graph.getEdges());
		//System.out.println(graph.getVertices());
		System.out.println(graph);
		System.out.println(graph.removeVertex("3"));
		System.out.println(graph);
	}
}
