public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list=new ArrayList<>();
        if(nums1.length==0||nums2.length==0) {
            return list;
        }
        PriorityQueue<Element> qu = new PriorityQueue<>();
        int onelen = nums1.length;
        int twolen = nums2.length;
        boolean[][] visited = new boolean[onelen][twolen];
        qu.offer(new Element(nums1[0] + nums2[0], 0, 0));
        visited[0][0] = true;
        while (!qu.isEmpty() && k > 0) {
            k--;
            Element cur = qu.poll();
            list.add(new int[]{nums1[cur.one], nums2[cur.two]});
            if (cur.one + 1 < onelen && !visited[cur.one + 1][cur.two]) {
                qu.offer(new Element(nums1[cur.one + 1] + nums2[cur.two], cur.one + 1, cur.two));
                visited[cur.one + 1][cur.two] = true;
            }
            if (cur.two + 1 < twolen && !visited[cur.one][cur.two + 1]) {
                qu.offer(new Element(nums1[cur.one] + nums2[cur.two + 1], cur.one, cur.two + 1));
                visited[cur.one][cur.two + 1] = true;
            }
        }
        return list;
    }
    class Element implements Comparable<Element>{
        int val;
        int one;
        int two;
        public Element(int val, int one, int two) {
            this.val = val;
            this.one = one;
            this.two = two;
        }
        public int compareTo(Element another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;
        }
    }
}


Using set, so override equals() and hashCode()

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list=new ArrayList<>();
        if(nums1.length==0||nums2.length==0) {
            return list;
        }
        PriorityQueue<Element> qu = new PriorityQueue<>();
        int onelen = nums1.length;
        int twolen = nums2.length;
        Set<Element> set = new HashSet<>();
        Element first = new Element(nums1[0] + nums2[0], 0, 0);
        qu.offer(first);
        set.add(first);
        while (!qu.isEmpty() && k > 0) {
            k--;
            Element cur = qu.poll();
            list.add(new int[]{nums1[cur.one], nums2[cur.two]});
            if (cur.one + 1 < onelen) {
                Element add1 = new Element(nums1[cur.one + 1] + nums2[cur.two], cur.one + 1, cur.two);
                if (set.add(add1)) {
                    qu.offer(add1);
                }
            }
            if (cur.two + 1 < twolen) {
                Element add2 = new Element(nums1[cur.one] + nums2[cur.two + 1], cur.one, cur.two + 1);
                if (set.add(add2)) {
                    qu.offer(add2);
                }
            }
        }
        return list;
    }
    class Element implements Comparable<Element>{
        int val;
        int one;
        int two;
        public Element(int val, int one, int two) {
            this.val = val;
            this.one = one;
            this.two = two;
        }
        @Override
        public int compareTo(Element another) {
            if (this.val == another.val) {
                return 0;
            }
            return this.val < another.val ? -1 : 1;
        }
        @Override
        public boolean equals (Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Element)) {
                return false;
            }
            Element another = (Element) obj;
            return this.one == another.one && this.two == another.two;
        }
        @Override
        public int hashCode() {
            return this.val * 31 * 31 + this.one * 31 + this.two;
        }
    }
}
