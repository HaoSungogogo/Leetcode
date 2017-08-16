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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = getMap(inorder);
        return buildTree(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder, map);
    }
    private TreeNode buildTree(int il, int ir, int[] inorder, int pl, int pr, int[] postorder, Map<Integer, Integer> map) {
        if (il > ir) {
            return null;
        }
        int val = postorder[pr];
        int len = ir - map.get(val);
        TreeNode root = new TreeNode(val);
        root.right = buildTree(ir - len + 1, ir, inorder, pr - len, pr - 1, postorder, map);
        root.left = buildTree(il, ir - len - 1, inorder, pl, pr - len - 1, postorder, map);
        return root;
    }
    private Map<Integer, Integer> getMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }
}
