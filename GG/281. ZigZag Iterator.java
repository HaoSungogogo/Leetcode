Multiple Iterators Operate One By One

public class ZigzagIterator {
    private Iterator<Integer>[] iterlist;
    private int pos;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterlist = new Iterator[]{v1.iterator(), v2.iterator()};
        pos = 0;
    }

    public int next() {
        int res = iterlist[pos].next();
        pos = pos == iterlist.length - 1 ? 0 : pos + 1;
        return res;
    }

    public boolean hasNext() {
        for (int i = pos; i < iterlist.length; i++) {
            if (iterlist[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        for (int i = 0; i < pos; i++) {
            if (iterlist[i].hasNext()) {
                pos = i;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
