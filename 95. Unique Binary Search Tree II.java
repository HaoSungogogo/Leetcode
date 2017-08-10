/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

The First way -> Using dfs, similar to construct tree, select a node and node.right / node.left

The time complexity is the Catalan Number C(n,2n)/(n+1) tends to be 4^n/n^(1.5)
https://en.wikipedia.org/wiki/Catalan_number

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
       return dfs(1 , n);
    }
   private List<TreeNode> dfs (int start, int end) {
       List<TreeNode> list = new ArrayList<>();
       if (start > end) {
           list.add(null);
           return list;
       }
       for (int i = start; i <= end; i++) {
           List<TreeNode> left = dfs(start, i - 1);
           List<TreeNode> right = dfs(i + 1, end);
           for (TreeNode lnode : left) {
               for (TreeNode rnode :  right) {
                   TreeNode root = new TreeNode(i);
                   root.left = lnode;
                   root.right = rnode;
                   list.add(root);
               }
           }
       }
       return list;
   }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

This is DP way and also need a copy of node

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        dp[0].add(null);
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
            for (int j = 0; j < i; j++) {
                for (TreeNode lnode : dp[j]) {
                    for (TreeNode rnode : dp[i - 1 - j]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = lnode;
                        root.right = copyNode(rnode, j + 1);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
   }
    private TreeNode copyNode(TreeNode node, int offset) {
        if (node == null) {
            return node;
        }
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = copyNode(node.left, offset);
        newNode.right = copyNode(node.right, offset);
        return newNode;
    }
}
