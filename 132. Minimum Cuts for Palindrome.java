O(n^3)
public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    int len = input.length();
    char[] array = input.toCharArray();
    int[] dp = new int[len + 1];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = i;
      for (int j = 0; j < i; j++) {
        if (checked(array, j, i - 1)) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    return dp[dp.length - 1] - 1;
  }
  private boolean checked(char[] array, int left, int right) {
    while (left < right) {
      if (array[left] != array[right]) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}


Using 2D boolean array to record the valid palindrome.
O(n^2)

public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }
    char[] array = input.toCharArray();
    int len = array.length;
    int[] dp = new int[len + 1];
    boolean[][] isP = new boolean[len + 1][len + 1];
    for (int j = 1; j <= len; j++) {
      dp[j] = j;
      for (int i = j; i >= 1; i--) {
        if (array[i - 1] == array[j - 1]) {
          isP[i][j] = j - i < 2 || isP[i + 1][j - 1];
        }
        if (isP[i][j]) {
          dp[j] = Math.min(dp[j], dp[i - 1] + 1);
        }
      }
    }
    return dp[len] - 1;
  }
}
