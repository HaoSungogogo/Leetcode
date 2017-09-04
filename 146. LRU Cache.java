class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            append(node);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                remove(tail);
            }
            append(newNode);
        }
    }

    private Node remove(Node node) {
        map.remove(node.key);
        if (node == tail && node == head) {
            tail = null;
            head = null;
            return node;
        }
        if (node == head) {
            head = node.next;
            node.next = null;
            head.prev = null;
            return node;
        }
        if (node == tail) {
            tail = node.prev;
            tail.next = null;
            node.prev = null;
            return node;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }

    private void append(Node node) {
        map.put(node.key, node);
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
