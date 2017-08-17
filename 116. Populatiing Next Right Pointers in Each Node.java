public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            TreeLinkNode next = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = qu.poll();
                cur.next = next;
                next = cur;
                if (cur.right != null) {
                    qu.offer(cur.right);
                }
                if (cur.left != null) {
                    qu.offer(cur.left);
                }
            }
        }
        return;
    }
}

Recursion way:
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
