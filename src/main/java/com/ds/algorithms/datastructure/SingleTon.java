package com.ds.algorithms.datastructure;

public class SingleTon {

	private static SingleTon singleTon;
	
	private SingleTon() {
		
	}
	
	public static SingleTon getInstnace() {
		if(singleTon == null) {
			singleTon = new SingleTon();
		}
		return singleTon;
	}
	
	public static void main (String args []) {
		
		SingleTon x = SingleTon.getInstnace();
		
		SingleTon y = SingleTon.getInstnace();
		SingleTon s = new SingleTon();
		
		System.out.println("Hascode of x is  "+x.hashCode());
		
		System.out.println("Hascode of y is  "+y.hashCode());
		
		System.out.println("Hascode of s is  "+s.hashCode());
		
		if(x.hashCode() ==  y.hashCode()) {
			System.out.println("Hascodes are same");
		}else {
			System.out.println("Hascodes are not same");
		}
	}
}
