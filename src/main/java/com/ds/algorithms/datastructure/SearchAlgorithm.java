package com.ds.algorithms.datastructure;

public class SearchAlgorithm {

	public static void main (String args[]) {
		
		int[] A = {3,5,8,15,67,95};
		
		int searchKey = 8;
		
		linearSearch(A, searchKey);
		binarySearch(A, searchKey);
	}

	private static void linearSearch(int[] a, int searchKey) {
	
		for(int i=0; i<a.length; i++) {
			if(a[i]==searchKey) {
				System.out.println("Search key found   "+ a[i]);
				break;
			}
		}
		
	}
	
	private static void binarySearch(int[] a, int searchKey) {
		int mid = a.length/2;
		if(searchKey == a[mid]) {
			System.out.println("Search key found   "+ a[mid]);
		}else if(searchKey > a[mid]) {
			for(int i=mid; i<a.length; i++) {
				if(searchKey == a[i]) {
					System.out.println("Search key found   "+ a[i]);
					break;
				}
			}
		}else if(searchKey < a[mid]) {
			for(int j=0; j<mid; j++) {
				if(searchKey == a[j]) {
					System.out.println("Search key found   "+ a[j]);
					break;
				}
			}
		}
	}
}
