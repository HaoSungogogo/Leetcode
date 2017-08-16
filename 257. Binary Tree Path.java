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
    public List<String> binaryTreePaths(TreeNode root) {
          List<String> list=new ArrayList<String>();
          if(root!=null) Recursion(root,list,"");
          return list;
    }
    public void Recursion(TreeNode root, List<String> list, String path){
        if(root.right==null&&root.left==null) list.add(path+root.val);
        if(root.left!=null) Recursion(root.left, list, path+root.val+"->");
        if(root.right!=null) Recursion(root.right, list, path+root.val+"->");
    }
}
