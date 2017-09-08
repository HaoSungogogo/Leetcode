class Solution {
    private int[] original;
    public Solution(int[] nums) {
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null || original.length == 0) {
            return original;
        }
        int[] rand = new int[original.length];
        for (int i = 0; i < rand.length; i++) {
            int j = (int)(Math.random() * (i + 1));
            rand[i] = rand[j];
            rand[j] = original[i];
        }
        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
