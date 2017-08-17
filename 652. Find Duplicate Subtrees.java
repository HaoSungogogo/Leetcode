Find the same substree, it comes to my mind the postorder traversal
In the current level, we need to link the string in post order.
Maintain the Map to Store the String and compare
Null node using "#" to represent, if so, we could make sure it is unique tree determined by postorder.

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        findDuplicateSubtrees(list, map, root);
        return list;
    }
    private String findDuplicateSubtrees(List<TreeNode> list, Map<String, Integer> map, TreeNode root) {
        if (root == null) {
            return "#";
        }
        String str = findDuplicateSubtrees(list, map, root.right) + "," + findDuplicateSubtrees(list, map, root.left)+ "," + root.val;
        Integer cur = map.getOrDefault(str, 0);
        if (cur == 1) {
            list.add(root);
        }
        map.put(str, cur + 1);
        return str;
    }
}
