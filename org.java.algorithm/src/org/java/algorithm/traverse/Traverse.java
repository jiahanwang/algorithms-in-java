package org.java.algorithm.traverse;

import org.java.algorithm.graph.*;
import java.util.*;


public class Traverse {
	
	public static <V, E> List<V> bfs(Graph<V, E> graph, V src, V des, Comparator<? super V > comparator){
		if(graph ==  null || src == null){
			throw new NullPointerException("Graph or source vertex is null");
		}
		if(!graph.containsVertex(src)){
			throw new IllegalArgumentException("Source vertex doesn't exist in graph");
		}
		if(des != null && !graph.containsVertex(des)){
			throw new IllegalArgumentException("Destination vertex doesn't exist in graph");
		}
		// need extra space to store marks for traversal, boolean for instance 
		Map<V, Boolean> traversalMarks = new HashMap<V, Boolean>();
		for(V vertex : graph.getVertices()){
			traversalMarks.put(vertex, false);
		}
		List<V> traversalList = new LinkedList<V>();
		Queue<V> queue = new LinkedList<V>();
		queue.add(src);
		while(!queue.isEmpty()){
			V vertex = queue.poll();
			traversalMarks.put(vertex,true);
			traversalList.add(vertex);
			// encounter the destination return
			if(des!= null && vertex.equals(des)){
				return Collections.unmodifiableList(traversalList);
			}
			List<V> adjacentVertices = new LinkedList<V>(graph.adjacentVertices(vertex));
			if(comparator != null){
				Collections.sort(adjacentVertices, comparator);
			}
			for(V adjacentVertex: adjacentVertices){
				if(traversalMarks.get(adjacentVertex) == false && !queue.contains(adjacentVertex)){
					queue.add(adjacentVertex);
				}
			}
		}
		return Collections.unmodifiableList(traversalList);
	}
	
	public static <V, E> List<V> bfs(Graph<V, E> graph, V source, Comparator<? super V > c){
		return bfs(graph, source, null, c);
	}
	
	public static <V, E> List<V> bfs(Graph<V, E> graph, V source, V destination){
		return bfs(graph, source, destination, null);
	}
	
	public static <V, E> List<V> bfs(Graph<V, E> graph, V source){
		return bfs(graph, source);
	}
	
	public static <V, E> List<V> dfs(Graph<V, E> graph, V src, V des, Comparator<? super V > comparator){
		if(graph ==  null || src == null){
			throw new NullPointerException("Graph or source vertex is null");
		}
		if(!graph.containsVertex(src)){
			throw new IllegalArgumentException("Source vertex doesn't exist in graph");
		}
		if(des != null && !graph.containsVertex(des)){
			throw new IllegalArgumentException("Destination vertex doesn't exist in graph");
		}
		// need extra space to store marks for traversal, boolean for instance 
		Map<V, Boolean> traversalMarks = new HashMap<V, Boolean>();
		for(V vertex : graph.getVertices()){
			traversalMarks.put(vertex, false);
		}
		// reverse the comparator
		comparator = Collections.reverseOrder(comparator);
		List<V> traversalList = new LinkedList<V>();
		Stack<V> stack = new Stack<V>();
		stack.push(src);
		while(!stack.isEmpty()){
			V vertex = stack.pop();
			traversalMarks.put(vertex,true);
			traversalList.add(vertex);
			// encounter the destination return
			if(des!= null && vertex.equals(des)){
				return Collections.unmodifiableList(traversalList);
			}
			List<V> adjacentVertices = new LinkedList<V>(graph.adjacentVertices(vertex));
			if(comparator != null){
				Collections.sort(adjacentVertices, comparator);
			}
			for(V adjacentVertex: adjacentVertices){
				if(traversalMarks.get(adjacentVertex) == false && !stack.contains(adjacentVertex)){
					stack.push(adjacentVertex);
				}
			}
		}
		return Collections.unmodifiableList(traversalList);
	}
	
	public static <V, E> List<V> dfs(Graph<V, E> graph, V source, Comparator<? super V > c){
		return dfs(graph, source, null, c);
	}
	
	public static <V, E> List<V> dfs(Graph<V, E> graph, V source, V destination){
		return dfs(graph, source, destination, null);
	}
	
	public static <V, E> List<V> dfs(Graph<V, E> graph, V source){
		return dfs(graph, source);
	}
	
	
	/*public void dfs_recursive(Graph<V, E> graph, V root, Collection<V> traversalList){
		if(traversalMarks.get(root) == true){
			return;
		}else{
			traversalMarks.put(root, true);
			traversalList.add(root);
		}
		List<V> adjacentVertices = new LinkedList<V>(graph.adjacentVertices(root));
		if(comparator != null)
			Collections.sort(adjacentVertices, comparator);
		for(V vertex : adjacentVertices){
			if(traversalMarks.get(vertex) == false){
				dfs_recursive(graph, vertex, traversalList);
			}
		}
	}*/
	
	
	public static void main(String[] args){
		SimpleGraph<String, String> graph = new SimpleGraph<String, String>();
		graph.addEdge("edge1-2", "1", "2");
		graph.addEdge("edge1-3", "1", "3");
		graph.addEdge("edge2-3", "2", "3");
		graph.addEdge("edge3-4", "3", "4");
		graph.addVertex("5");
		graph.addEdge("edge1-5", "1", "5");
		graph.addVertex("6");
		
		System.out.println(Traverse.bfs(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		}));
		
		System.out.println(Traverse.dfs(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		}));
		
		BFSIterator<String, String> iterator = new BFSIterator<String, String>(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		for(;iterator.hasNext();){
			System.out.println(iterator.next());
		}
		
		DFSIterator<String, String> iterator2 = new DFSIterator<String, String>(graph, "1", new Comparator<String>(){
			public int compare(String a, String b){
				return a.compareTo(b);
			}
		});
		for(;iterator2.hasNext();){
			System.out.println(iterator2.next());
		}
	}
	
}
