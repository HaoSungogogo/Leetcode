Want to be randomized, Need index, so We need an arrayList.

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer temp = map.get(val);
        if (temp != null) {
            return false;
        }
        int loc = list.size();
        list.add(val);
        map.put(val, loc);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer temp = map.get(val);
        if (temp == null) {
            return false;
        }
        if (temp != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(temp, last);
            map.put(last, temp);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        int index = (int)(Math.random() * size);
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
