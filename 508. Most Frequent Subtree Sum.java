/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Using post-order to solve
Map to record th frequency and also record the max frequency

public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = new int[]{0};
        dfs(root, map, max);
        for (Integer key : map.keySet()) {
            if (map.get(key) == max[0]) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private int dfs(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, map, max);
        int right = dfs(root.right, map, max);
        int val = left + right + root.val;
        Integer cur = map.get(val);
        if (cur == null) {
            cur = 1;
            map.put(val, cur);
        } else {
            map.put(val, ++cur);
        }
        max[0] = Math.max(max[0], cur);
        return val;
    }
}
