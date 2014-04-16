package org.java.algorithm.graph;

import java.util.Collection;

public interface DirectedGraph<V, E> {
	
	V destination(E edge);
	
	V origin(E edge);
	
	
	int inDegree(V vertex);
	
	int outDegree(V vertex);
	
	
	Collection<E> inAdjacentVertices(V vertex);
	
	Collection<E> outAdjacentVertices(V vertex);
	
	
	Collection<E> inIncidentEdges(V vertex);
	
	Collection<E> outIncidentEdges(V vertex);
	
	
	boolean revert(E edge);
	
	DirectedGraph<V,E> revertAll();
}
