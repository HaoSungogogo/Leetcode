/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Only have one order could not reconstruct the tree. But when we add "#" as leave, we could recontruct.
Using level order to serialize.
In the deserialize process, we also need a queue to imitate the level order process.

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = qu.poll();
                if (cur != null) {
                    sb.append(cur.val);
                    sb.append(',');
                    qu.offer(cur.left);
                    qu.offer(cur.right);
                } else {
                    sb.append("#");
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] str = data.split(",");
        int j = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[j++]));
        qu.offer(root);
        while(j < str.length) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = qu.poll();
                if (!str[j].equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(str[j]));
                    cur.left = left;
                    qu.offer(left);
                } else {
                    cur.left = null;
                }
                j++;
                if (!str[j].equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(str[j]));
                    cur.right = right;
                    qu.offer(right);
                } else {
                    cur.right = null;
                }
                j++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
