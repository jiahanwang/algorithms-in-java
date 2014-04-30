package org.java.algorithm.sorting.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import org.java.algorithm.sorting.MergeSort;
import org.java.algorithm.sorting.QuickSort;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {

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
	public void testQuickSortCollection() {
		assertEquals("QuickSort Collection", QuickSort.quickSort(sourceList, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		}), resultListReversed);
	}

	@Test
	public void testQuickSortCollectionWithoutComparator() {
		assertEquals("QuickSort Collection", QuickSort.quickSort(sourceList), resultList);
	}

	@Test
	public void testQuickSortCollectionWithIndex() {
		assertEquals("QuickSort Collection", QuickSort.quickSort(sourceList, 2, 7, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		}), partialResultListReversed);
	}

	@Test
	public void testQuickSortCollectionWithIndexWithoutComparator() {
		assertEquals("QuickSort Collection", QuickSort.quickSort(sourceList, 2, 7), partialResultList);
	}

	@Test
	public void testQuickSortArray() {
		QuickSort.quickSort(source, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		});
		assertEquals("QuickSort Array", source, resultReversed);
	}

	@Test
	public void testQuickSortArrayWithoutComparator() {
		QuickSort.quickSort(source);
		assertEquals("QuickSort Array", source, result);
	}

	@Test
	public void testQuickSortArrayWithIndex() {
		QuickSort.quickSort(source, 2, 7, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return - a.compareTo(b);
			}
		});
		assertEquals("QuickSort Array", source, partialResultReversed);
	}

	@Test
	public void testQuickSortArrayWithIndexWithoutComparator() {
		QuickSort.quickSort(source, 2, 7);
		assertEquals("QuickSort Array", source, partialResult);
	}
}
