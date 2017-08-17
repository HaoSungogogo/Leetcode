DP + DFS
Maintain two value, the one does not include root itself, the other includes.

public class Solution {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dfs(TreeNode root) {
        int[] array = new int[2];
        if (root == null) {
            return array;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        array[0] = root.val + left[1] + right[1];
        array[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return array;
    }
}
