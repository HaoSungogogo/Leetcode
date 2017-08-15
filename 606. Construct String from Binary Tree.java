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
    public String tree2str(TreeNode t) {
        return treeTostr(t).toString();
    }
    private StringBuilder treeTostr(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t == null) {
            return sb;
        }
        sb.append(t.val);
        if (t.left == null && t.right == null) {
            return sb;
        }
        if (t.left == null) {
            sb.append("()");
        } else {
            sb.append('(');
            sb.append(treeTostr(t.left).toString());
            sb.append(')');
        }
        if (t.right == null) {
            return sb;
        } else {
            sb.append('(');
            sb.append(treeTostr(t.right).toString());
            sb.append(')');
        }
        return sb;
    }
}
