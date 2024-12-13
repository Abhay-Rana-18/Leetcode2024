class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        int[][] dp = new int[n][2];
        for (int i=0; i<n; i++) {
            dp[i][0] = i;
            dp[i][1] = nums[i];
        }
        boolean[] vis = new boolean[n];
        Arrays.sort(dp, (a, b) -> a[1]-b[1]);
        for (int[] ar: dp) {
            int idx = ar[0];
            int val = ar[1];
            if (vis[idx]) continue;
            vis[idx] = true;
            if (idx!=0) {
                vis[idx-1] = true;
            }
            if (idx!=n-1) {
                vis[idx+1] = true;
            }
            score += val;
        }
        return score;
    }
}
