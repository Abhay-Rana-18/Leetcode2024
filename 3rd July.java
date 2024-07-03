class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n<=4) {
            return 0;
        }
        int small = nums[0];
        int large = nums[n-1];
        int s = 0;
        int e = n-1;
        int a = nums[n-1] - nums[3];
        int b = nums[n-4] - nums[0];
        int c = nums[n-3] - nums[1];
        int d = nums[n-2] - nums[2];
        int ans = Math.min(a, b);
        ans = Math.min(ans, c);
        ans = Math.min(ans, d);
        return ans;
    }
}
