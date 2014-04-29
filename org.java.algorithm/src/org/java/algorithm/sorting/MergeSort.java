package org.java.algorithm.sorting;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MergeSort {
	
	/**
	 * 
	 * 
	 * 
	 * */
	public static <T> Collection<T> mergeSort(Collection<T> values){
		return mergeSort(values, 0, values.size() - 1, null);
	}
	
	public static <T> Collection<T> mergeSort(Collection<T> values, Comparator<? super T> c){
		return mergeSort(values, 0, values.size() - 1, c);
	}
	
	public static <T> Collection<T> mergeSort(Collection<T> values, int fromIndex, int toIndex){
		return mergeSort(values, fromIndex, toIndex, null);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> mergeSort(Collection<T> values, int fromIndex, int toIndex, Comparator<? super T> c){
		if(values.size() <= 1)
			return values;
		if(fromIndex > toIndex || fromIndex < 0 || toIndex > values.size() - 1){
			throw new IllegalArgumentException("fromIndex or toIndex is wrong");
		}
		T[] valuesArray = (T[])values.toArray();
		mergeSort(valuesArray, fromIndex, toIndex, c);
		return Arrays.asList(valuesArray);
	}
	
	
	/**
	 * 
	 * 
	 * */
	public static <T> void mergeSort(T[] values){
		mergeSort(values, 0, values.length - 1, null);
	}
	
	public static <T> void mergeSort(T[] values, Comparator<? super T> c){
		mergeSort(values, 0, values.length - 1, c);
	}
	
	public static <T> void mergeSort(T[] values, int fromIndex, int toIndex){
		mergeSort(values, fromIndex, toIndex, null);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void mergeSort(T[] values, int fromIndex, int toIndex, Comparator<? super T> c){
		if(values.length <= 1)
			return;
		if(fromIndex > toIndex || fromIndex < 0 || toIndex > values.length - 1){
			throw new IllegalArgumentException("fromIndex or toIndex is wrong");
		}
		// need a helper array with size of length / 2 + 1, when merging copy left half into helper
		T[] helper = (T[])(new Object[values.length / 2 + 1]);
		mergeSort_recursive(values, helper, fromIndex, toIndex, c);
	}
	
	/**
	 * 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	private static <T> void mergeSort_recursive(T[] values, T[] helper, int fromIndex, int toIndex, Comparator<T> c){
		//when fromIndex == toIndex return, or stack overflow
		if(fromIndex >= toIndex) return;
		int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
		mergeSort_recursive(values, helper, fromIndex ,middleIndex, c);
		mergeSort_recursive(values, helper, middleIndex + 1, toIndex, c);
		int leftLen = middleIndex - fromIndex + 1;
		// copy values[] to helper[], values[] is the final result
		System.arraycopy(values, fromIndex, helper, 0, leftLen);
		// merge two halves to values[]
		int i = 0, j = middleIndex + 1, k = fromIndex;
		for(; k <= toIndex;){
			// if all elements in helper have been moved to values, then values is sorted
			if(i >= leftLen) break;
			if(c != null){
				values[k++] = ( j > toIndex || c.compare(helper[i], values[j]) <= 0 )? helper[i++] : values[j++];
			}
			else{
				values[k++] = ( j > toIndex || ((Comparable)helper[i]).compareTo(values[j]) <= 0 ) ? helper[i++] : values[j++];
			}
		}
	}

}
