package org.java.algorithm.traverse;

import org.java.algorithm.graph.Graph;
import java.util.*;


public class DFSIterator<V, E> extends AbstractGraphIterator<V, E>{

	DFSIterator(Graph<V, E> graph, V src, V des, Comparator<? super V> c){
		super(graph, src, des, c);
		// reverse comparator
		if(c != null){
			setComparator(Collections.reverseOrder(c));
		}
	}
	
	DFSIterator(Graph<V, E> graph, V src, Comparator<? super V> c){
		this(graph, src, null, c);
	}
	
	DFSIterator(Graph<V, E> graph, V src, V des){
		this(graph, src, des, null);
	}
	
	DFSIterator(Graph<V, E> graph, V src){
		this(graph, src, null, null);
	}
	
	public boolean hasNext() {
		return !getDesEncountered() && !isEmpty();
	}

	public V next() {
		if (!hasNext()){
            throw new NoSuchElementException();
		}
		V vertex = pollLast();
		setMark(vertex, true);
		if(getDestination() != null && vertex.equals(getDestination())){
			setDesEncountered(true);
			return vertex;
		}
		List<V> adjacentVertices = new LinkedList<V>(getGraph().adjacentVertices(vertex));
		if(getComparator() != null){
			Collections.sort(adjacentVertices, getComparator());
		}
		for(V adjacentVertex : adjacentVertices){
			if(getMark(adjacentVertex) == false && !contains(adjacentVertex)){
				addLast(adjacentVertex);
			}
		}
		return vertex;
	}
}
