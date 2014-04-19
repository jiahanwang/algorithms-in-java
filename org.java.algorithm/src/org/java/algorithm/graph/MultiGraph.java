package org.java.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * A multigraph. A multigraph is a non-simple undirected graph in which no loops
 * are permitted, but multiple edges between any two vertices are. If you're
 * unsure about multigraphs, see: <a
 * href="http://mathworld.wolfram.com/Multigraph.html">
 * http://mathworld.wolfram.com/Multigraph.html</a>.
 */

public class MultiGraph<V, E> extends AbstractUndirectedGraph<V, E>{
	
	public MultiGraph(){
		super();
	}
	
	@Override
	public boolean addEdge(E edge, V vertex1, V vertex2) {
		if(edge == null || vertex1 == null || vertex2 == null) 
    		throw new IllegalArgumentException("Edges cannot contain null values");
		if(edges.containsKey(edge)){
			return false;
		}
		// loop is not allowed
		if(vertex1.equals(vertex2))
			return false;
		// multiple edge is allowed
		addVertex(vertex1);
		vertices.get(vertex1).add(edge);
		addVertex(vertex2);
		vertices.get(vertex2).add(edge);
		edges.put(edge, new Pair<V>(vertex1, vertex2));
		return true;
	}

}
