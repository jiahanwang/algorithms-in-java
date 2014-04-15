package org.java.algorithm.graph;

import java.util.*;

public abstract class AbstractGraph<V,E> {
	
	public abstract boolean addEdge(E e, V v1, V v2);
	
	public abstract boolean removeEdge(E e);
	
	public abstract boolean addVertex(V vertex);
	
	public abstract boolean removeVertex(V vertext);
	
	public abstract int numOfVertices();
	
	public abstract int numOfEdges();
	
	public abstract Collection<V> getVertices();
	
	public abstract Collection<E> getEdges();
	
	public abstract Collection<V> adjacentVertices(E e);
	
	public abstract Collection<E> incidentEdges(V vertex);
	
	public abstract boolean areAdjacent(V v1, V v2);
	
	public abstract boolean areIncident(V vertex, E edge);
	
	public abstract int degree(V vertex);
	
}
