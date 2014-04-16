package org.java.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

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
		if(vertices.containsKey(vertex1) && vertices.containsKey(vertex2)){
			if(areAdjacent(vertex1, vertex2)){
				return false;
			}
		}
		if(vertices.containsKey(vertex1)){
			vertices.get(vertex1).add(edge);
		}else{
			Set<E> newSet= new HashSet<E>();
			newSet.add(edge);
			vertices.put(vertex1, newSet);
		}
		if(vertices.containsKey(vertex2)){
			vertices.get(vertex2).add(edge);
		}else{
			Set<E> newSet = new HashSet<E>();
			newSet.add(edge);
			vertices.put(vertex2, newSet);
		}
		edges.put(edge, new Pair<V>(vertex1, vertex2));
		return true;
	}
}
