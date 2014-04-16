package org.java.algorithm.graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractUndirectedGraph<V, E>
			extends AbstractGraph<V, E>
			implements UndirectedGraph<V, E> {
	
	// implemented in adjacent list by default
	Map<V, Set<E>>  vertices;
	Map<E, Pair<V>> edges;
	
	public AbstractUndirectedGraph(){
		super();
		vertices = new HashMap<V, Set<E>>();
		edges = new HashMap<E, Pair<V>>();
	}

	@Override
	public boolean addEdge(E edge, V vertex1, V vertex2) {
		if(edge == null || vertex1 == null || vertex2 == null) 
    		throw new IllegalArgumentException("Edges cannot contain null values");
		if(edges.containsKey(edge)){
			return false;
		}
		// allow loops and multiple edges by default
		edges.put(edge, new Pair<V>(vertex1, vertex2));
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
		return true;
	}

	@Override
	public boolean addVertex(V vertex) {
		if(vertex == null) 
    		throw new IllegalArgumentException("Vertices cannot contain null values");
		if(vertices.containsKey(vertex)){
			// this vertex already exists
			return false;
		}else{
			vertices.put(vertex, new HashSet<E>());
			return true;
		}
	}

	@Override
	public boolean removeEdge(E edge) {
		if(!edges.containsKey(edge)){
			// this edge doesn't exist (including null)
			return false;
		}else{
			Pair<V> pair = edges.get(edge);
			if(vertices.containsKey(pair.getSource()))
				vertices.get(pair.getSource()).remove(edge);
			if(vertices.containsKey(pair.getDestination()))
				vertices.get(pair.getDestination()).remove(edge);
			edges.remove(edge);
			return true;
		}
	}

	@Override
	public boolean removeVertex(V vertex) {
		if(!vertices.containsKey(vertex)){
			// this vertex doesn't exist(including null)
			return false;
		}else{
			// remove all the adjacent edges
			for(E edge : vertices.get(vertex)){
				removeEdge(edge);
			}
			vertices.remove(vertex);
			return true;
		}
	}
	
	@Override
	public int numOfVertices() {
		return vertices.size();
	}

	@Override
	public int numOfEdges() {
		return edges.size();
	}

	@Override
	public boolean containsVertex(V vertex) {
		return vertices.containsKey(vertex);
	}

	@Override
	public boolean containsEdge(E edge) {
		return edges.containsKey(edge);
	}

	@Override
	public Collection<V> getVertices() {
		return Collections.unmodifiableCollection(vertices.keySet());
	}

	@Override
	public Collection<E> getEdges() {
		return Collections.unmodifiableCollection(edges.keySet());
	}

	@Override
	public Collection<V> adjacentVertices(V vertex) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public Collection<E> incidentEdges(V vertex) {
		if(!vertices.containsKey(vertex)){
			return null;
		}else{
			return Collections.unmodifiableCollection(vertices.get(vertex));
		}
	}

	@Override
	public boolean areAdjacent(V vertex1, V vertex2) {
		if(! vertices.containsKey(vertex1) || ! vertices.containsKey(vertex2)){
			return false;
		}else{
			// must create a new Set
			Set<E> adjacentList = new HashSet<E>(vertices.get(vertex1));
			adjacentList.retainAll(vertices.get(vertex2));
			if(adjacentList.size() == 0){
				return false;
			}else{
				return true;
			}
		}
	}

	@Override
	public boolean areIncident(V vertex, E edge) {
		if(! vertices.containsKey(vertex) || ! edges.containsKey(edge)){
			return false;
		}else{
			return edges.get(edge).contains(vertex);
		}
	}

	@Override
	public Collection<E> endVertices(E edge) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public V opposite(E edge, V vertex) {
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	public int degree(V vertex) {
		if(!vertices.containsKey(vertex)){
			// return -1 when this vertex doesn't exist
			return -1;
		}else{
			return vertices.get(vertex).size();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(V vertex: vertices.keySet()){
			builder.append(vertex).append(": ").append(vertices.get(vertex)).append("\n");
		}
		return builder.toString();
	}


}