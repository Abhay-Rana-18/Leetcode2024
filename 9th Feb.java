class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[]dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxSize = 1;
        int maxIndex = 0;

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i]%nums[j]==0) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if (maxSize<dp[i]) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i=maxIndex; i>=0; i--) {
            if (num%nums[i]==0 && dp[i]==maxSize) {
                ans.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }

        return ans;
    }
}
