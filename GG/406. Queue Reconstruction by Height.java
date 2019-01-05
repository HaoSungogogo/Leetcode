class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return 1;
                } else if (a[0] > b[0]) {
                    return -1;
                } else {
                    return a[1] - b[1];
                }
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        int[][] res = new int[people.length][2];
        int cur = 0;
        for (int[] i : list) {
            res[cur++] = i;
        }
        return res;
    }
}
