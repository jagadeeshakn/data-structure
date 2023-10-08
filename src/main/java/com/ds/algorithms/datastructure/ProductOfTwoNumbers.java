package com.ds.algorithms.datastructure;

public class ProductOfTwoNumbers {

	public static void main (String args[]) {
		int a = 0;
		int b = 0;
		int prod = 0;
		prod = product(a, b);
		int res = findProduct(a, b);
		System.out.println("Product of two integers is  "+prod);
		System.out.println("Product of two integers is  "+res);
	}

	private static int product(int a, int b) {
		// if a is less than b then swap the numbers
		if(a < b) {
			return product(b, a);
			// iteratively calculate b times sum of a
		}else if(b != 0) {
			return a+product(a, b-1);
		}else {
			// if any of the two numbers is zero return zero
			return 0;
		}
	}
	
	private static int findProduct(int a, int b) {
		 if (b !=0) {
			return a+findProduct(a, b-1);
		}else {
			return 0;
		}
	}
}
