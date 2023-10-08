package com.ds.algorithms.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise {
	
	String s = "abc";
	String s1 = "abc";
	String s2 = new String("abc");
	public void method() {
		//== operator compares reference or memory location of objects in a heap, 
		//whether they point to the same location or not.
	if(s==s1) {
		//both have the same addresses in the string constant pool.
		System.out.println("true");
		System.out.println("Hascode of s is  "+s.hashCode());
		System.out.println("Hascode of s1 is  "+s1.hashCode());
		}else {
			System.out.println("false");
		}
	
//	We can use == operators for reference comparison (address comparison) and .equals()
//			method for content comparison. In simple words, == checks if both objects point 
//			to the same memory location whereas .equals() evaluates 
//			to the comparison of values in the objects.
	if(s1.equals(s2)) {
		System.out.println("true");
		}else {
			System.out.println("false");
		}
	
	if(s1 == s2) {
		System.out.println("true");
		System.out.println("Hascode of s1 is  "+s1.hashCode());
		System.out.println("Hascode of s2 is  "+s2.hashCode());
		}else {
			System.out.println("false");
			System.out.println("Hascode of s1 is  "+s1.hashCode());
			System.out.println("Hascode of s2 is  "+s2.hashCode());
		}
	
	}
	
	public List<String> lambda() {
		List<String> names = new ArrayList<>();
		names.add("R&D");
		names.add("IT");
		names.add("SUPPORT");
		return names.stream().filter(l -> l.equals("R&D")).collect(Collectors.toList());
		 //return names.stream().filter(n -> n.equals("IT")).findAny();
		 
		
	}
	
	public static void main(String [] args) {
		
		Exercise ex = new Exercise();
		ex.method();
		List<String> result = ex.lambda();
		if(!result.isEmpty()) {
			System.out.println("List item   " + result);
		}
	}

}
