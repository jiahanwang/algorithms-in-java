package org.java.algorithm.graph;

import java.util.Collection;

public interface Graph<V, E> {
	
	boolean addEdge(E edge, V vertex1, V vertex2);
	
	boolean addVertex(V vertex);

	
	boolean removeEdge(E edge);
	
	boolean removeAllEdgs(Collection<? extends E> edges);

	boolean removeVertex(V vertex);
	
	boolean removeAllVertices(Collection<? extends V> vertices);
	
	
	int numOfVertices();
	
	int numOfEdges();
	
	
	Collection<V> getVertices();
	
	Collection<E> getEdges();
	
	
	boolean containsVertex(V vertex);
	
	boolean containsEdge(E edge);
	
	
	Collection<V> adjacentVertices(V vertex);
	
	Collection<E> incidentEdges(V vertex);
	
	
	boolean areAdjacent(V vertex1, V vertex2);
	
	boolean areIncident(V vertex, E edge);
	
	
	Collection<E> endVertices(E edge);
	
	V opposite(E edge, V vertex);
	

}