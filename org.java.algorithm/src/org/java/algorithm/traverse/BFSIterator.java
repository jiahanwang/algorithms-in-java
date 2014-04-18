package org.java.algorithm.traverse;

import org.java.algorithm.graph.Graph;
import java.util.*;


public class BFSIterator<V, E> extends AbstractGraphIterator<V, E>{

	private Queue<V> queue;
	
	BFSIterator(Graph<V, E> graph, V src, V des, Comparator<? super V> c){
		super(graph, src, des, c);
		queue = new LinkedList<V>();
		queue.add(src);
	}
	
	BFSIterator(Graph<V, E> graph, V src, Comparator<? super V> c){
		this(graph, src, null, c);
	}
	
	BFSIterator(Graph<V, E> graph, V src, V des){
		this(graph, src, des, null);
	}
	
	BFSIterator(Graph<V, E> graph, V src){
		this(graph, src, null, null);
	}
	
	@Override
	public boolean hasNext() {
		return !getDesEncountered() && !queue.isEmpty();
	}

	@Override
	public V next() {
		if (!hasNext()){
            throw new NoSuchElementException();
		}
		V vertex = queue.poll();
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
			if(getMark(adjacentVertex) == false && !queue.contains(adjacentVertex)){
				queue.add(adjacentVertex);
			}
		}
		return vertex;
	}
	
}