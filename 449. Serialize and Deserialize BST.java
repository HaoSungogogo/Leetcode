/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Using comma to seperate the node and parse
If not, it will parse wrong.

Parse process: String[] str = data.split(",");
               Integer.parseInt(str[i]);

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }
    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        sb.append(',');
        if (root.left != null) {
            preOrder(root.left, sb);
        }
        if (root.right != null) {
            preOrder(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] list = data.split(",");
        int[] preorder = new int[list.length];
        int[] inorder = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            preorder[i] = Integer.parseInt(list[i]);
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        Map<Integer, Integer> map = getMap(inorder);
        return reconstruct(0, inorder.length - 1, inorder, 0, preorder.length - 1, preorder, map);
    }
    private TreeNode reconstruct(int istart, int iend, int[] inorder, int pstart, int pend, int[] preorder,
                                 Map<Integer, Integer> map) {
        if (istart > iend) {
            return null;
        }
        int val = preorder[pstart];
        TreeNode root = new TreeNode(val);
        int len = map.get(val) - istart;
        root.left = reconstruct(istart, istart + len - 1, inorder, pstart + 1, pstart + len, preorder, map);
        root.right = reconstruct(istart + len + 1, iend, inorder, pstart + len + 1, pend, preorder, map);
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
