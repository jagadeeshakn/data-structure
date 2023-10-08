package com.ds.algorithms.datastructure;

import java.util.Arrays;

public class SmallestInteger {

	public int findSmallest(int A[]) {
		int min = A[0];
		Arrays.sort(A);
		for(int i=0; i<A.length; i++) {
			if(A[i] < min) {
				min = A[i];
			}
		}
		for(int i=0; i<A.length; i++) {
			if(min == A[i]) {
				min = min+1;
			}
		}
		if(min<=0) {
			return 1;
		}
		return min;
		
	}
	
	public static void main(String args[]) {
		int [] A = {-1,-3};
		SmallestInteger s = new SmallestInteger();
		int res = s.findSmallest(A);
		System.out.println("Smallest integer in a given array A "+res);
	}
}
