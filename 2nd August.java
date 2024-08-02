class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i]==1) {
                ones++;
            }
        }
        int z = 0;
        for (int j=0; j<ones; j++) {
                if (nums[j]==0) {
                    z++;
                }
            }
        int ans = z;
        for (int i=1; i<n; i++) {
            if (nums[i-1]==0) {
                z--;
            }
            if (nums[(i+ones-1)%n] == 0) {
                z++;
            }
            ans = Math.min(z, ans);
        }
        return ans;
    }
}
