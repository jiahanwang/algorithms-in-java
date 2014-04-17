package org.java.algorithm.graph;

public abstract class AbstractVertex {
	
	private String id;
	
	AbstractVertex(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
