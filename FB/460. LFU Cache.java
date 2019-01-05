Using first map to store the key map to requests.
second map to store the count map to key of requests.
min to maintain the min counts for the requests in the cache.
Maintain these three fields.

Map<Count -> LinkedHashSet>
First, we want to remove any key in the middle in O(1) -> need to use HashTable or Doubly LinkedList
At the same time, we want the order, so we use the LinkedHashSet -> we could get order by using iterator.

class LFUCache {
    static class Node {
        int key;
        int value;
        int count;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }
    private Map<Integer, Node> map;
    private Map<Integer, LinkedHashSet<Integer>> countList;
    private int limit;
    private int min;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        countList = new HashMap<>();
        countList.put(1, new LinkedHashSet<Integer>());
        limit = capacity;
        min = 1;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int res = node.value;
        int counts = node.count;
        node.count++;
        countList.get(counts).remove(key);
        if (counts == min && countList.get(counts).size() == 0) {
            min++;
        }
        LinkedHashSet<Integer> list = countList.get(counts + 1);
        if (list == null) {
            list = new LinkedHashSet<Integer>();
            countList.put(counts + 1, list);
        }
        list.add(key);
        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            get(key);
        } else {
            if (limit == map.size()) {
                int evit = countList.get(min).iterator().next();
                countList.get(min).remove(evit);
                map.remove(evit);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            countList.get(1).add(key);
            min = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
