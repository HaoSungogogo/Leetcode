/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
Time Complexity: O(n^2logn)

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Pair> qu = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        qu.offer(new Pair(root, 0));
        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            int idx = pair.index;
            TreeNode n = pair.node;
            List<Integer> l = map.get(idx);
            if (l == null) {
                l = new ArrayList<Integer>();
                map.put(idx, l);
            }
            l.add(n.val);
            if (n.left != null) {
                qu.offer(new Pair(n.left, idx - 1));
            }
            if (n.right != null) {
                qu.offer(new Pair(n.right, idx + 1));
            }
        }
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }
    class Pair {
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}

Not Using TreeMap, only record min and max.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;
        while (!qu.isEmpty()) {
            Pair pair = qu.poll();
            int idx = pair.index;
            TreeNode nd = pair.node;
            List<Integer> l = map.get(idx);
            if (l == null) {
                l = new ArrayList<Integer>();
                map.put(idx, l);
            }
            l.add(nd.val);
            if (nd.left != null) {
                qu.offer(new Pair(nd.left, idx - 1));
                min = Math.min(min, idx - 1);
            }
            if (nd.right != null) {
                qu.offer(new Pair(nd.right, idx + 1));
                max = Math.max(max, idx + 1);
            }
        }
        for (int j = min; j <= max; j++) {
            list.add(map.get(j));
        }
        return list;
    }
    class Pair {
        TreeNode node;
        int index;
        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}
