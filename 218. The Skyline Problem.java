The location where the height changes only appear on the these two index
So when we traverse these location, only we maintain a PriorityQueue get the local max.


public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] iter : buildings) {
            height.add(new int[]{iter[0], -iter[2]});
            height.add(new int[]{iter[1], iter[2]});
        }
        Collections.sort(height, new NewComparator());
        PriorityQueue<Integer> pq = new PriorityQueue<>(11, Collections.reverseOrder());
        pq.offer(0);
        int pre = 0;
        for (int[] ele : height) {
            if (ele[1] < 0) {
                pq.offer(-ele[1]);
            } else {
                pq.remove(ele[1]);
            }
            Integer cur = pq.peek();
            if (cur != pre) {
                res.add(new int[]{ele[0], cur});
                pre = cur;
            }
        }
        return res;
    }
    class NewComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if(a[0] < b[0]) {
                return -1;
            } else if (a[0] > b[0]) {
                return 1;
            } else if (a[1] < b[1]) {
                return -1;
            } else if (a[1] > b[1]) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
