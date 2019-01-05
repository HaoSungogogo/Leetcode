If it is perfect square,
1. the total area is equal to the sum of each square.
2. each vertex appear twice except the vertices of largest square.

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        for (int[] vertex : rectangles) {
            x1 = Math.min(x1, vertex[0]);
            y1 = Math.min(y1, vertex[1]);
            x2 = Math.max(x2, vertex[2]);
            y2 = Math.max(y2, vertex[3]);
            area += (vertex[3] - vertex[1]) * (vertex[2] - vertex[0]);
            String s1 = vertex[0] + "," + vertex[1];
            String s2 = vertex[0] + "," + vertex[3];
            String s3 = vertex[2] + "," + vertex[1];
            String s4 = vertex[2] + "," + vertex[3];
            if (!set.add(s1)) {
                set.remove(s1);
            }
            if (!set.add(s2)) {
                set.remove(s2);
            }
            if (!set.add(s3)) {
                set.remove(s3);
            }
            if (!set.add(s4)) {
                set.remove(s4);
            }
        }
        if (!set.contains(x1 + "," + y1) || !set.contains(x1 + "," + y2) || !set.contains(x2 + "," + y1) ||
            !set.contains(x2 + "," + y2) || set.size() != 4) {
            return false;
        }
        return area == (y2 - y1) * (x2 - x1);
    }
}
