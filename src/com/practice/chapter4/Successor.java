package com.practice.chapter4;

public class Successor {

	
	private static class BSTTreeNode {
		int data;
		BSTTreeNode left, right;
		
		BSTTreeNode(int data) {
			this.data = data;
		}
	}
	
	BSTTreeNode getSuccessor(BSTTreeNode root, int data) {
		
		// Search the node : O(h) 
		BSTTreeNode currentNode = search(root, data); // O(h)
		if (currentNode == null) return null;
		
		// Case 1: Node has right subtree -> Find min in the right subtree : O(h)
		if (currentNode.right != null) { 
			BSTTreeNode temp = currentNode.right;
			while (temp.left != null)
				temp = temp.left;
			return temp;
		} else {
			// Case 2: Node has no right subtree -> Find the non-visited ancestor : // O(h)
			BSTTreeNode successor = null;
			BSTTreeNode ancestor = root;
			
			while (ancestor != currentNode) {
				if (currentNode.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.left;
				} else
					ancestor = ancestor.right;
			}
			return successor;
			
		}
	}
	
	private BSTTreeNode search(BSTTreeNode root, int data) {		
		
		if (root == null || root.data == data) return root;
		
		if (root.data < data) return search(root.right, data);
		
		return search(root.left, data);			
	}
}


