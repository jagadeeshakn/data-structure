package com.ds.algorithms.datastructure;

import java.util.HashSet;
import java.util.Set;

public class RotateArray {

	public static void main(String args[]) {
		int[] R = { 1, 3, 4, 7, 9, 7, 0, 2 };
		int k = 10;
		int n = R.length;
		//rotate(R, n, k);
		int[] S = { 1, 3, 4, 7, 9, 7, 0, 2, 3, 4 };
		int d = 2;
		int l = S.length;
		findDuplicates(S, d, l);
	}

	public static int[] rotate(int[] R, int n, int k) {
		k = k % n;
		for (int i = 0; i < R.length; i++) {
			if (i < k) {
				System.out.print(R[n + i - k] + " ");
			} else {
				System.out.print(R[i - k] + " ");
			}
		}
		return R;
	}

	private static void findDuplicates(int[] S, int d, int l) {
		Set<Integer> c = new HashSet<>();
		for (int p = 0; p < l; p++) {
			int a = S[p];
			int b=0;
			for (int q = 0; q < l; q++) {
				if(S[q]== a) {
					b++;
					if(b==d) {
						c.add(S[q]);
						break;
					}
				}
			}
		}
		System.out.println("Number of duplicate presents  "+c.size());
	}
}
