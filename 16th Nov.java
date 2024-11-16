class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        if (k==1) return nums;
        int[] ans = new int[n-k+1];
        for (int i=0; i+k<=n; i++) {
            int prev = nums[i];
            for (int j=i+1; j<i+k; j++) {
                if (nums[j]-prev==1) {
                    prev = nums[j];
                    if (j==i+k-1) {
                        ans[i] = nums[j];
                    }
                }
                else {
                    ans[i] = -1;
                    break;
                }
            }
        }
        return ans;
    }
}
