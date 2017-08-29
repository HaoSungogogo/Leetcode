class Solution {
	  public List<List<Integer>> allFactors(int num) {
	    List<List<Integer>> list = new ArrayList<>();
	    if (num <= 1) {
	    	return list;
	    }
	    List<Integer> factor = getFactor(num);
	    List<Integer> cur = new ArrayList<>();
	    dfs(list, cur, factor, 0, num);
	    return list;
	  }
	  private void dfs(List<List<Integer>> list, List<Integer> cur, List<Integer> factor,
			  int level, int target) {
		  if (level == factor.size()) {
			  if (target == 1) {
				  list.add(new ArrayList<Integer>(cur));
			  }
			  return;
		  }
		  int fac = factor.get(level);
		  dfs(list, cur, factor, level + 1, target);
		  int count = 0;
		  while (target % fac == 0) {
			 count++;
			 cur.add(fac);
			 target = target / fac;
			 dfs(list, cur, factor, level + 1, target);
		  }
		  while (count > 0) {
			  cur.remove(cur.size() - 1);
			  count--;
		  }
	  }
	  private List<Integer> getFactor(int num) {
		  List<Integer> res = new ArrayList<>();
		  for (int i = num - 1; i > 1; i--) {
			  if (num % i == 0) {
				  res.add(i);
			  }
		  }
		  return res;
	  }
}
