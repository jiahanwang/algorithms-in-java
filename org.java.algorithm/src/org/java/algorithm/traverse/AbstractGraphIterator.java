package org.java.algorithm.traverse;

import java.util.*;

import org.java.algorithm.graph.Graph;

public abstract class AbstractGraphIterator<V, E> implements Iterator<V>{
	
	private Map<V, Boolean> traversalMarks;
	private final Graph<V, E> graph;
	private V destination;
	private Comparator<? super V> comparator;
	private boolean desEncountered = false;
	
	public AbstractGraphIterator(Graph<V, E> graph, V src, V des, Comparator<? super V> c){
		if(graph ==  null || src == null){
			throw new NullPointerException("Graph or source vertex is null");
		}
		if(!graph.containsVertex(src)){
			throw new IllegalArgumentException("Source vertex doesn't exist in graph");
		}
		if(des != null && !graph.containsVertex(des)){
			throw new IllegalArgumentException("Destination vertex doesn't exist in graph");
		}
		setDestination(des);
		setComparator(c);
		this.graph = graph;
		traversalMarks = new HashMap<V, Boolean>();
		for(V vertex : graph.getVertices()){
			traversalMarks.put(vertex, false);
		}
	}
	
	protected boolean getMark(V vertex){
		return traversalMarks.get(vertex);
	}
	
	protected void setMark(V vertex, boolean mark){
		traversalMarks.put(vertex, mark);
	}
	
	protected Graph<V, E> getGraph() {
		return graph;
	}

	protected V getDestination() {
		return destination;
	}

	protected void setDestination(V destination) {
		this.destination = destination;
	}

	protected Comparator<? super V> getComparator() {
		return comparator;
	}

	protected void setComparator(Comparator<? super V> comparator) {
		this.comparator = comparator;
	}
	
	protected boolean getDesEncountered() {
		return desEncountered;
	}

	protected void setDesEncountered(boolean desEncountered) {
		this.desEncountered = desEncountered;
	}
	
	@Override
	public void remove(){
        throw new UnsupportedOperationException();
    }
}
