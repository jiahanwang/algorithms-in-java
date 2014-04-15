package org.java.algorithm.graph;

import java.util.Collection;

public class SimpleDirectedGraph<V,E> extends AbstractGraph<V,E> implements DirectedGraph<V,E>{

	@Override
	public boolean addEdge(E e, V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVertex(V vertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(V vertext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<E> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<V> adjacentVertices(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<E> incidentEdges(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areAdjacent(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areIncident(V vertex, E edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int degree(V vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegree(V vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outDegree(V vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean revert(E edge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DirectedGraph<V, E> revertAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
