package org.java.algorithm.graph;

public class Pair<T>{
	
	private T first;
	private T second;
	
	public Pair(T value1, T value2){
    	if(value1 == null || value2 == null) 
    		throw new IllegalArgumentException("Pair cannot contain null values");
        setFirst(value1);
        setSecond(value2);
    }

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
}