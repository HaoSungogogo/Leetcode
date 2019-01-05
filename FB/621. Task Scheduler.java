class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] counter = new char[26];
        for (char c : tasks) {
            counter[c - 'A']++;
        }
        Arrays.sort(counter);
        int i = 1;
        int val = counter[counter.length - 1];
        for (int j = counter.length - 2; j >= 0; j--) {
            if (counter[j] == val) {
                i++;
            } else {
                break;
            }
        }
        return Math.max(tasks.length, (val - 1) * (n + 1) + i);
    }
}

first, we need to find out the set of most frequent elements and get the frequency is k
so we create the k chuncks and put these element into the fixed index in each chuncks.
Then append less frequent element in decending order to the end of each first k - 1 chuncks.
So we have 2 situations.
1. the rest of element do not fill out all the gap in the first k - 1 chunks.
 we will return (val - 1) * (n + 1) + i
2. the rest of element can fill out all the gap, we will return the length, since we do not need any idle to
isolate the tasks.


class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (char c : tasks) {
        	Integer cur = map.get(c);
        	if (cur == null) {
        		map.put(c, res++);
        	} else {
        		if (res - cur > n) {
        			map.put(c, res++);
        		} else {
        			res = cur + n + 1;
        			map.put(c, res++);
        		}
        	}
        }
        return res;
    }
}
