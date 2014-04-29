package org.java.algorithm.sorting.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import org.java.algorithm.sorting.MergeSort;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

	Integer[] source;
	Integer[] result;
	Integer[] resultReversed;
	Integer[] partialResult;
	Integer[] partialResultReversed;
	LinkedList<Integer> sourceList = new LinkedList<Integer>();
	LinkedList<Integer> resultList = new LinkedList<Integer>();
	LinkedList<Integer> resultListReversed = new LinkedList<Integer>();
	LinkedList<Integer> partialResultList = new LinkedList<Integer>();
	LinkedList<Integer> partialResultListReversed = new LinkedList<Integer>();

	@Before
	public void setUp() throws Exception {
		source = new Integer[]{4, 5, 2, 5, 7, 2, 4, 99, 22, 66};
		result = new Integer[]{2, 2, 4, 4, 5, 5, 7, 22, 66, 99};
		resultReversed = new Integer[]{99, 66, 22, 7, 5, 5, 4, 4, 2, 2};
		partialResult = new Integer[]{4, 5, 2, 2, 4, 5, 7, 99, 22, 66};
		partialResultReversed = new Integer[]{4, 5, 99, 7, 5, 4, 2, 2, 22, 66};
		sourceList.addAll(Arrays.asList(source));
		resultList.addAll(Arrays.asList(result));
		resultListReversed.addAll(Arrays.asList(resultReversed));
		partialResultList.addAll(Arrays.asList(partialResult));
		partialResultListReversed.addAll(Arrays.asList(partialResultReversed));
	}
	
	@Test
	public void testMergeSortCollection() {
		assertEquals("Mergesort Collection", MergeSort.mergeSort(sourceList, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		}), resultListReversed);
	}

	@Test
	public void testMergeSortCollectionWithoutComparator() {
		assertEquals("Mergesort Collection", MergeSort.mergeSort(sourceList), resultList);
	}

	@Test
	public void testMergeSortCollectionWithIndex() {
		assertEquals("Mergesort Collection", MergeSort.mergeSort(sourceList, 2, 7, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		}), partialResultListReversed);
	}

	@Test
	public void testMergeSortCollectionWithIndexWithoutComparator() {
		assertEquals("Mergesort Collection", MergeSort.mergeSort(sourceList, 2, 7), partialResultList);
	}

	@Test
	public void testMergeSortArray() {
		MergeSort.mergeSort(source, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		});
		assertEquals("Mergesort Array", source, resultReversed);
	}

	@Test
	public void testMergeSortArrayWithoutComparator() {
		MergeSort.mergeSort(source);
		assertEquals("Mergesort Array", source, result);
	}

	@Test
	public void testMergeSortArrayWithIndex() {
		MergeSort.mergeSort(source, 2, 7, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		});
		assertEquals("Mergesort Array", source, partialResultReversed);
	}

	@Test
	public void testMergeSortArrayWithIndexWithoutComparator() {
		MergeSort.mergeSort(source, 2, 7);
		assertEquals("Mergesort Array", source, partialResult);
	}

}
