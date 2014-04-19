package org.java.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple graph. A simple graph is an undirected graph for which at most one
 * edge connects any two vertices, and loops are not permitted. 
 * 
 */

public class SimpleGraph<V,E> extends AbstractUndirectedGraph<V,E>{
	
	public SimpleGraph(){
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
		// multiple edge is not allowed
		if(areAdjacent(vertex1, vertex2)){
				return false;
		}
		addVertex(vertex1);
		vertices.get(vertex1).add(edge);
		addVertex(vertex2);
		vertices.get(vertex2).add(edge);
		edges.put(edge, new Pair<V>(vertex1, vertex2));
		return true;
	}
}
