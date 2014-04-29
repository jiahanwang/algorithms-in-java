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
	public static <T> Collection<T> mergeSort(Collection<T> values, Comparator<? super T> c){
		return mergeSort(values, 0, values.size() - 1, c);
	}
	
	public static <T> Collection<T> mergeSort(Collection<T> values){
		return mergeSort(values, 0, values.size() - 1, null);
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
	public static <T> void mergeSort(T[] values, Comparator<? super T> c){
		mergeSort(values, 0, values.length - 1, c);
	}
	
	public static <T> void mergeSort(T[] values){
		mergeSort(values, 0, values.length - 1, null);
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
		T[] helper = (T[])(new Object[values.length]);
		mergeSort_recursive(values, helper, fromIndex, toIndex, c);
	}
	
	/**
	 * 
	 * 
	 * */
	@SuppressWarnings("unchecked")
	private static <T> void mergeSort_recursive(T[] values, T[] helper, int fromIndex, int toIndex, Comparator<T> c){
		if(values.length > 1 && fromIndex < toIndex){
			int middleIndex = fromIndex + (toIndex - fromIndex) / 2;
			mergeSort_recursive(values, helper, fromIndex ,middleIndex, c);
			mergeSort_recursive(values, helper, middleIndex + 1, toIndex, c);
			// copy values[] to helper[], values[] is the final result
			for(int i = fromIndex; i <= toIndex; i++){
				helper[i] = values[i];
			}
			// remove to values[]
			int i = fromIndex, j = middleIndex + 1, k = fromIndex;
			for(; i <= middleIndex && j <= toIndex;){
				if(c != null){
					values[k++] = c.compare(helper[i], helper[j]) <= 0 ? helper[i++] : helper[j++];
				}
				else{
					values[k++] = ((Comparable)helper[i]).compareTo(helper[j]) <= 0 ? helper[i++] : helper[j++];
				}
			}
			// remove rest to values[]
			if(i > middleIndex){
				while(j <= toIndex)
					values[k++] = helper[j++];
			}else{
				while(i <= middleIndex)
					values[k++] = helper[i++];
			}
		}
	}
	
	/*public static void main(String[] args){
		Integer[] array = new Integer[]{4, 5, 2, 5, 7, 2, 4, 99, 22, 66};
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(Arrays.asList(array));
		MergeSort.mergeSort(array, 1, 6);
		for(Integer i : array){
			System.out.println(i);
		}
		System.out.println(MergeSort.mergeSort(list, 7, 6));
		
	}
*/
}
