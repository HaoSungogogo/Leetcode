class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer cur = map.get(i);
            if (cur == null) {
                map.put(i, 1);
            } else {
                map.put(i, cur + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>> () {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> iter : list) {
            res.add(iter.getKey());
            if (res.size() == k) {
            	break;
            }
        }
        return res;
    }
}

Using bucket to store each entry. The index is based on the time of certain element appearance.
the bucket is value map.
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer cur = map.get(i);
            if (cur == null) {
                map.put(i, 1);
            } else {
                map.put(i, cur + 1);
            }
        }
       List<Integer>[] bucket=new List[nums.length + 1];
       int value;
       for(Map.Entry<Integer, Integer> iter : map.entrySet()){
           value = iter.getValue();
           if(bucket[value] == null) bucket[value] = new ArrayList<Integer>();
           bucket[value].add(iter.getKey());
       }
       for(int j = bucket.length-1; j >= 0 && k > 0; j--){
           if(bucket[j] != null) {
               list.addAll(bucket[j]);
               k -= bucket[j].size();
           }
       }
       return list;
    }
}
