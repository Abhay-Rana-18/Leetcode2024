class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Edge case: if target is out of possible range
        if (target > totalSum || target < -totalSum) {
            return 0;
        }

        // Use a smaller dp array with range [-totalSum, totalSum]
        int[][] dp = new int[n][2 * totalSum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return find(nums, 0, target, 0, dp, totalSum);
    }

    private int find(int[] nums, int i, int target, int sum, int[][] dp, int offset) {
        // Base case: when we reach the end of the array
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Check memoization
        if (dp[i][sum + offset] != -1) {
            return dp[i][sum + offset];
        }

        // Recursively calculate the number of ways
        int add = find(nums, i + 1, target, sum + nums[i], dp, offset);
        int subtract = find(nums, i + 1, target, sum - nums[i], dp, offset);

        // Store result in dp array
        dp[i][sum + offset] = add + subtract;

        return dp[i][sum + offset];
    }
}
