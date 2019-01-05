class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] h : buildings) {
            int[] start = new int[]{h[0], h[2]};
            int[] end = new int[]{h[1], -h[2]};
            height.add(start);
            height.add(end);
        }
        Collections.sort(height, new newComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1);
        int pre = 0;
        for (int[] h : height) {
             if (h[1] > 0) {
                 Integer cur = map.get(h[1]);
                 if (cur == null) {
                     map.put(h[1], 1);
                 } else {
                     map.put(h[1], cur + 1);
                 }
             } else {
                 Integer cur = map.get(-h[1]);
                 if (cur == 1) {
                     map.remove(-h[1]);
                 } else {
                     map.put(-h[1], cur - 1);
                 }
             }
            int curHeight = map.firstKey();
            if (pre != curHeight) {
                int[] entry = new int[]{h[0], curHeight};
                res.add(entry);
                pre = curHeight;
            }
        }
        return res;
    }
    class newComparator implements Comparator<int[]> {
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }
    }
}
ß

class Solution {
    public String getRand(Map<String, Integer> map) {
        int[] acc = new int[map.size()];
        String[] name = new String[map.size()];
        int cur = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (cur == 0) {
                acc[cur] = entry.getValue();
            } else {
                acc[cur] = acc[cur - 1] + entry.getValue();
            }
            name[cur] = entry.getKey();
            cur++;
        }
        int num = (int)(Math.random() * acc[acc.length - 1]) + 1;
        int index = binarySearch(acc, num);
        return name[index];
    }
    private int binarySearch(int[] acc, int val) {
        int left = 0;
        int right = acc.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (acc[mid] >= val) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (acc[left] >= val) {
            return left;
        } else {
            return right;
        }
    }
}


class RandPopulation {
  private Map<String, Integer> map;
  private Random random;
  public RandPopulation (Map<String, Integer> map) {
    this.map = map;
    random = new Random();
  }
  public String getRandom() {
    int count = 0;
    String res = "";
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int num = entry.getValue();
      count += num;
      if (random.nextInt(count) <= num - 1) {
        res = entry.getKey();
      }
    }
    return res;
  }
}


public TreeNode invert(TreeNode root) {
  if (root == null) {
    return null;
  }
  TreeNode left = invert(root.left);
  TreeNode right = invert(root.rihgt);
  root.left = right;
  root.right = left;
  return root;
}

public void preOrder(TreeNode root) {
  if (root == null) {
    return;
  }
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerFirst(root);
  while (!stack.isEmpty()) {
    TreeNode cur = root.pollFirst();
    System.out.println(cur.val);
    if (cur.right != null) {
      root.offerFirst(cur.right);
    }
    if (cur.left != null) {
      root.offerFirst(cur.left);
    }
  }
}

public void inOrder (TreeNode root) {
  if (root == null) {
    return;
  }
  Deque<TreeNode> stack = new LinkedList<>();
  stack.offerFirst(root);
  TreeNode cur = root.left;
  while (!stack.isEmpty()) {
    if (cur != null) {
      stack.offerFirst(cur);
      cur = cur.left;
    } else {
      TreeNode res = stack.pollFirst();
      System.out.println(res.val);
      if (res.right != null) {
        stack.offerFirst(res.right);
        cur = res.right.left;
      }
    }
  }
}

public int height(TreeNode root) {
  if (root == null) {
    return 0;
  }
  int left = height(root.left);
  int right = height(root.right);
  return Math.max(left, right) + 1;
}

public boolean isBalanced(TreeNode root) {
  if (root == null) {
    return true;
  }
  int left = height(root.left);
  int right = height(root.right);
  if (Math.abs(left - right) > 1) {
    return false;
  }
  return isBalanced(root.left) && isBalanced(root.right);
}
