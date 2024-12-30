class Solution {
    private static final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        return find(low, high, zero, one, 0, dp);
    }

    private int find(int low, int high, int zero, int one, int curr, int[] dp) {
        if (curr>high) {
            return 0;
        }
        if (dp[curr] != -1) {
            return dp[curr];
        }
        int addedZero = find(low, high, zero, one, curr+zero, dp)%MOD;
        int addedOne = find(low, high, zero, one, curr+one, dp)%MOD;
        int ans = (addedZero + addedOne)%MOD;
        if (curr>=low) {
            ans++;
        }
        dp[curr] = ans;
        return ans;
    }
}
