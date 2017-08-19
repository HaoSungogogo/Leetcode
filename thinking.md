problem of BST
1. think about property first.
2. inorder traversal could be used
3. passing the boundary along the path could be used.

A path from root to leaf base case at the (root.left == 0 && root.right == 0)
if (root.left != null) {dfs}
if (root.right != null) {dfs}

Using BFS and Topological Sort -> the vertex could be traverse in order if it does not have circle
Maintain an indegree array, when the indegree of vertex decreases to 0, add it  

Only dereference can retain value in the recursion.

Path Count in DP problem (every cell record the number of path to get here)
Normal :dp[i][j] = dp[i- 1][j] + dp[i][j - 1];
567: for every version of count represents the number of way to get to certain location in certain step.
int nx = x + d[0];
int ny = y + d[1];
temp[nx][ny] = (temp[nx][ny] + count[x][y])
