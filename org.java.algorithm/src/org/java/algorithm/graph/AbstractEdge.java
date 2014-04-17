package org.java.algorithm.graph;

public abstract class AbstractEdge {
	
	private String id;

	AbstractEdge(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
