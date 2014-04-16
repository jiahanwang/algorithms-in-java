package org.java.algorithm.graph;

import java.util.Collection;

public abstract class AbstractGraph<V, E> implements Graph<V, E> {
	
	protected AbstractGraph() {
	}

	@Override
	public boolean removeAllEdgs(Collection<? extends E> edges) {
		boolean modified = false;
		for(E edge : edges){
			modified |= removeEdge(edge);
		}
		return modified;
	}

	@Override
	public boolean removeAllVertices(Collection<? extends V> vertices) {
		boolean modified = false;
        for (V vertex : vertices) {
            modified |= removeVertex(vertex);
        }
        return modified;
	}

	@Override
	public int numOfVertices() {
		return getVertices().size();
	}

	@Override
	public int numOfEdges() {
		return getEdges().size();
	}

	@Override
	public boolean containsVertex(V vertex) {
		return getVertices().contains(vertex);
	}

	@Override
	public boolean containsEdge(E edge) {
		return getEdges().contains(edge);
	}
	
}
