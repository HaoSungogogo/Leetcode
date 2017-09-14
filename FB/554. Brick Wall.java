Using HashMap to store the number of cut in certain location.

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                Integer cur = map.get(length);
                if (cur != null) {
                    cur++;
                } else {
                    cur = 1;
                }
                map.put(length, cur);
                max = Math.max(max, cur);
            }
        }
        return wall.size() - max;
    }
}
