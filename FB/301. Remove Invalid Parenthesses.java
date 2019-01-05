class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        dfs(list, s, 0, 0 , new char[]{'(', ')'});
        return list;
    }
    private void dfs(List<String> list, String s, int lastRmv, int lastTraverse, char[] pair) {
        int stack = 0;
        for (int i = lastTraverse; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                stack++;
            }
            if (s.charAt(i) == pair[1]) {
                stack--;
            }
            if (stack < 0) {
                for (int j = lastRmv; j <= i; j++) {
                    if (s.charAt(j) == pair[1] && (j == lastRmv || s.charAt(j) != s.charAt(j - 1))) {
                        dfs(list, s.substring(0, j) + s.substring(j + 1), j, i, pair);
                    }
                }
                return;
            }
        }
        String newStr = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            dfs(list, newStr, 0, 0, new char[]{')', '('});
        } else {
            list.add(newStr);
        }
    }
}
O(nk) k is the length of result and n is the length of input string

class Solution {
    public String removeInvalidParentheses(String s) {
        return helper(s, new char[]{'(', ')'});
    }
    private String helper(String s, char[] pair) {
    	int stack = 0;
    	int i = 0;
    	while (i < s.length()) {
    		if (s.charAt(i) == pair[0]) {
    			stack++;
    		}
    		if (s.charAt(i) == pair[1]) {
    			stack--;
    		}
    		if (stack < 0) {
    			s = s.substring(0, i) + s.substring(i + 1);
    			stack++;
    			continue;
    		}
    		i++;
    	}
    	String newStr = new StringBuilder(s).reverse().toString();
    	if (pair[0] == '(') {
    		return helper(newStr, new char[]{')', '('});
    	} else {
    		return newStr;
    	}
    }
}
