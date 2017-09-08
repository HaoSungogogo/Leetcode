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


DFS + Memorization
recursion + map to store the result of subproblem
First to check out whether this map has this value. if has, return directly. if not, recursion

public class Solution {
  public long fibonacci(int K) {
    if (K < 0) {
      return 0;
    }
    Map<Integer, Long> map = new HashMap<>();
    map.put(0, 0L);
    map.put(1, 1L);
    return dfs(K, map);
  }
  private long dfs(int target, Map<Integer, Long> map) {
    Long l = map.get(target);
    if (l != null) {
      return l;
    }
    long one = dfs(target - 1, map);
    long two = dfs(target - 2, map);
    map.put(target, one + two);
    return one + two;
  }
}

stack
1. 32. Longest Valid Parentheses -> Parentheses problem. store -1 first to record the mismatched index and store the index of Parentheses
   301. Remove Invalid Parentheses -> using counter to model the stack
2. 84. Largest Rectangle in Histogram -> store the index of Rectangle and maintain the height of ascending order.
3. 239. Sliding Window Maximum -> if the current is larger than the head of stack. poll the head (又大又新的代替)
