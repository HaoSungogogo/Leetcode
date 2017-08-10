沙子归并 ＋ preprocessing the array to get the number larger than one bit.

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return list;
        }
        int len = input.length();
        char[] array = input.toCharArray();
        List<Pair> num = new ArrayList<>();
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
        	int n = 0;
        	while (fast < len && isDigit(array[fast])) {
        		n = n * 10 + array[fast] - '0';
        		fast++;
        	}
        	num.add(new Pair(n, slow, fast - 1));
        	slow = fast + 1;
        }
        int size = num.size();
        List<Integer>[][] dp = new List[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = j; i >= 0; i--) {
                dp[i][j] = new ArrayList<Integer>();
                if (i == j) {
                    dp[i][j].add(num.get(i).val);
                } else {
                    for (int k = i; k < j; k++) {
                        List<Integer> left = dp[i][k];
                        List<Integer> right = dp[k + 1][j];
                        dp[i][j].addAll(operation(left, right, num.get(k).end + 1, array));
                    }
                }
            }
        }
        return dp[0][size - 1];
    }
    private List<Integer> operation(List<Integer> left, List<Integer> right, int index, char[] array) {
        List<Integer> res = new ArrayList<>();
        for (Integer l : left) {
            for (Integer r : right) {
                if (array[index] == '+') {
                    res.add(l + r);
                } else if (array[index] == '-') {
                    res.add(l - r);
                } else {
                    res.add(l * r);
                }
            }
        }
        return res;
    }

    private boolean isDigit(char c) {
    	if (c >= '0' && c <= '9') {
    		return true;
    	} else {
    		return false;
    	}
    }

    class Pair {
    	int val;
    	int start;
    	int end;
    	public Pair(int val, int start, int end) {
    		this.val = val;
    		this.start = start;
    		this.end = end;
    	}
    }
}
