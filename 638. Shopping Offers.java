N-nary tree dfs, each branch is each sales
Similar to 99 cents.

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || price.size() == 0 || special == null || special.size() == 0 ||
           needs == null || needs.size() == 0) {
            return 0;
        }
        int[] min = new int[]{Integer.MAX_VALUE};
        dfs (min, price, special, needs, 0);
        return min[0];
    }
    private void dfs (int[] min, List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cost) {
        boolean flag = true;
        for (List<Integer> iter : special) {
            if (check(iter, needs)) {
                flag = false;
                int nonsale = 0;
                for (int i = 0; i < needs.size(); i++) {
                    int num = iter.get(i);
                    nonsale += num * price.get(i);
                    needs.set(i, needs.get(i) - num);
                }
                if (nonsale < iter.get(iter.size() - 1)) {
                    dfs(min, price, special, needs, cost + nonsale);
                } else {
                    dfs(min, price, special, needs, cost + iter.get(iter.size() - 1));
                }
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) + iter.get(i));
                }
            }
        }
        if (flag) {
            for (int i = 0; i < needs.size(); i++) {
                Integer num = needs.get(i);
                if (num > 0) {
                    cost += num * price.get(i);
                }
            }
            min[0] = Math.min(min[0], cost);
            return;
        }
    }
    private boolean check(List<Integer> iter, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < iter.get(i)) {
                return false;
            }
        }
        return true;
    }
}
