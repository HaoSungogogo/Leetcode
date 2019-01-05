package test;

import java.util.*;

public class test{
	public static void main (String[] args) {

//		Solution sol = new Solution();
//		System.out.println(sol.addBoldTag("abcxyz123", new String[]{"abc","123"}));


		Solution.TreeNode root = new Solution.TreeNode(3);
		Solution sol = new Solution();
		sol.insertNode(1, root);
		sol.insertNode(4, root);
		sol.insertNode(2, root);
		System.out.println(sol.getRandom(root));


	}
}


class Solution {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int size;
		public TreeNode(int val) {
			this.val = val;
			size = 1;
		}
	}
	public TreeNode insertNode(int value, TreeNode root) {
		if (root == null) {
			return new TreeNode(value);
		}
		if (value < root.val) {
			root.left = insertNode(value, root.left);
		} else {
			root.right = insertNode(value, root.right);
		}
		root.size++;
		return root;
	}
	public int getRandom (TreeNode root) {
		int leftSize = root.left == null ? 0 : root.left.size;
		Random rand = new Random();
		int index = rand.nextInt(root.size);
		if (index < leftSize) {
			return getRandom(root.left);
		} else if (index == leftSize) {
			return root.val;
		} else {
			return getRandom(root.right);
		}
	}
}
