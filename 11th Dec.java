class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int i=0; i<n; i++) {
            if (nums[i]>maxVal) {
                maxVal = nums[i];
            }
        }
        int[] prefix = new int[maxVal+10];
        for (int i=0; i<n; i++) {
            int left = Math.max(nums[i] - k, 0);
            int right = Math.min(nums[i] + k, maxVal) + 1;
            prefix[left]++;
            prefix[right]--;
        }
        int ans = prefix[0];
        for (int i=1; i<prefix.length; i++) {
            prefix[i] += prefix[i-1];
            ans = Math.max(ans, prefix[i]);
        }
        return ans;
    }
}
