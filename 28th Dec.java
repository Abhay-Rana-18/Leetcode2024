class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][3];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i=1; i<n; i++) {
            pre[i] = pre[i-1] + nums[i];
        }

        int cnt = 0;
        int i = k-1;
        int[] ans = new int[3];
        while (i<n && cnt<3) {
            int sum = pre[i] - (i-k>=0 ? pre[i-k] : 0);
            int added = sum + findMax(pre, n, k, dp, i+k, cnt+1);
            int skip = findMax(pre, n, k, dp, i+1, cnt);

            if (added>=skip) {
                ans[cnt] = i-k+1>=0 ? i-k+1 : 0;
                i += k;
                cnt++;
            }
            else {
                i++;
            }
        }

        return ans;
    }

    private int findMax(int[] pre, int n, int k, int[][] dp, int i, int cnt) {
        if (i>=n || cnt>=3) {
            return 0;
        }
        if (dp[i][cnt] != -1) {
            return dp[i][cnt];
        }
        int sum = pre[i] - (i-k>=0 ? pre[i-k] : 0);
        
        int added = sum + findMax(pre, n, k, dp, i+k, cnt+1);
        int skip = findMax(pre, n, k, dp, i+1, cnt);

        return dp[i][cnt] = Math.max(added, skip);
    }   

}
