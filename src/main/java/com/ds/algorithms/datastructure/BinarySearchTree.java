package com.ds.algorithms.datastructure;

public class BinarySearchTree {

	public static class Node {
		int data;
		Node right, left;
	}

	public static Node newNode(int data) {

		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return node;
	}

	public static int minValue(Node node) {

		if(node == null) {
			return Integer.MAX_VALUE;
		}
		int value = node.data;
		int rightMax = minValue(node.right);
		int leftMax = minValue(node.left);
		return Math.min(value, Math.min(leftMax, rightMax));
	}

	public static int maxValue(Node node) {

		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int value = node.data;
		int rightMax = maxValue(node.right);
		int leftMax = maxValue(node.left);
		return Math.max(value, Math.max(leftMax, rightMax));
	}
	
	public static int isBst(Node node) {
		if(node == null) {
			return 1;
		}
		
		if(node.left != null
				&& maxValue(node.left) > node.data) {
			return 0;
		}
		
		if(node.right != null
				&& minValue(node.right) < node.data) {
			return 0;
		}
		
		if(isBst(node.left)!= 1
				|| isBst(node.right)!= 1) {
			
			return 0;
		}
		return 1;
	}
	
	public static void main(String[] args)
	  {
	    Node root = newNode(4);
	    root.left = newNode(5);
	    root.right = newNode(2);
	     
	    // root->right->left = newNode(7);
	    root.left.left = newNode(1);
	    root.left.right = newNode(3);
	 
	    // Function call
	    if (isBst(root) == 1) {
	      System.out.print("Is BST");
	    }
	    else {
	      System.out.print("Not a BST");
	    }
	  }
}
