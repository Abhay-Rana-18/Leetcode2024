class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, c = 0, maxcount = 0;
        for (int n : nums) max = Math.max(max, n);
        for (int n : nums) {
            if (n == max) c++;
            else {
                maxcount = Math.max(maxcount, c);
                c = 0;
            }
        }
        return Math.max(maxcount, c);
    }
}
