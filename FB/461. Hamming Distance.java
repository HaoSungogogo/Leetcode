class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 && y != 0) {
            count += (x & 1) ^ (y & 1);
            x >>>= 1;
            y >>>= 1;
        }
        while (x != 0) {
            count += x & 1;
            x >>>= 1;
        }
        while (y != 0) {
            count += y & 1;
            y >>>= 1;
        }
        return count;
    }
}


class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((xor >> i) & 1);
        }
        return count;
    }
}
