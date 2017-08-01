/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> map = getMap(inorder);
    return reconstruct(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
  }
  private TreeNode reconstruct (int[] in, int in1, int in2, int[] pre, int pre1,
  int pre2, Map<Integer, Integer> map) {
    if (pre1 > pre2) {
      return null;
    }
    int val = pre[pre1];
    int len = map.get(val) - in1;
    TreeNode root = new TreeNode(val);
    root.left = reconstruct(in, in1, in1 + len - 1, pre, pre1 + 1, pre1 + len, map);
    root.right = reconstruct(in, in1 + len + 1, in2, pre, pre1 + len + 1, pre2, map);
    return root;
  }
  private Map<Integer, Integer> getMap(int[] in) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    return map;
  }
}