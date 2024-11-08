class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int [n];
        int limit = (1 << maximumBit) -1;
        int xor = nums[0];
        ans[n-1] = limit ^ xor;

        for (int i=1; i<n; i++) {
            xor ^= nums[i];
            ans[n-i-1] = limit ^ xor;
        }

        return ans;
    }
}
