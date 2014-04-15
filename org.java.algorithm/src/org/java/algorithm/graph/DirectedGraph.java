package org.java.algorithm.graph;

public interface DirectedGraph <V, E> {
	
	int inDegree(V vertex);
	int outDegree(V vertex);
	boolean revert(E edge);
	DirectedGraph<V,E> revertAll();
}
