Using BFS from leaves to root. (一层一层)
leaves -> adjacent list has only one element.
O(E) + O(V + E) = O(V + E)

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        LinkedList<Integer> list = new LinkedList<>();
        if (n <= 0) {
            return list;
        }
        if (n == 1) {
            list.add(0);
            return list;
        }

        List<Integer>[] nei = new List[n];
        for (int i = 0; i < edges.length; i++) {
            int one = edges[i][0];
            int two = edges[i][1];
            if (nei[one] == null) {
                nei[one] = new ArrayList<Integer>();
            }
            if (nei[two] == null) {
                nei[two] = new ArrayList<Integer>();
            }
            nei[one].add(two);
            nei[two].add(one);
        }

        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nei[i].size() == 1) {
                qu.offer(i);
            }
        }

        int count = n;
        while(count > 2) {
            int size = qu.size();
            count -= size;
            for (int i = 0; i < size; i++) {
                Integer cur = qu.poll();
                for (Integer iter : nei[cur]) {
                    nei[iter].remove(cur);
                    if (nei[iter].size() == 1) {
                        qu.offer(iter);
                    }
                }
            }
        }
        while(!qu.isEmpty()) {
            list.add(qu.poll());
        }
        return list;
    }
}
