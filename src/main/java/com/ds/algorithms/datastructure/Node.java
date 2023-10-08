package com.ds.algorithms.datastructure;

public class Node {
	int data;
	Node right, left;

	public Node(int item) {
		data = item;
		left = right = null;

	}
	
	public static class BinaryTree {
		Node root;

		void mirror() {
			root = mirror(root);
		}

		private Node mirror(Node root) {
			if (root == null) {
				return root;
			}
			/* traverse the subtrees */
			Node left = mirror(root.left);
			Node right = mirror(root.right);
			/* swap the nodes */
			root.left = right;
			root.right = left;

			return root;
		}

		void inOrder() {
			inOrder(root);
		}

		private void inOrder(Node root) {

			if (root == null) {
				return;
			}
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
		
		public static void main(String args []) {
			BinaryTree tree = new BinaryTree();
			tree.root = new Node(1);
			tree.root.left = new Node(2);
			tree.root.right = new Node(3);
			tree.root.left.left = new Node(4);
			tree.root.right.right = new Node(5);
			
			System.out.println("Binary tree before mirroring ");
			tree.inOrder();
			System.out.println("  ");
			tree.mirror();
			System.out.println("Binary tree after mirroring ");
			tree.inOrder();
			
		}
	}
	
}
