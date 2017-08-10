problem of BST
1. think about property first.
2. inorder traversal could be used
3. passing the boundary along the path could be used.

A path from root to leaf base case at the (root.left == 0 && root.right == 0)
if (root.left != null) {dfs}
if (root.right != null) {dfs}

Using BFS and Topological Sort -> the vertex could be traverse in order if it does not have circle
Maintain an indegree array, when the indegree of vertex decreases to 0, add it  
