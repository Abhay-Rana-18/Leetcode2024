class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for (int i=0; i<k; i++) {
            int min = nums[0];
            int idx = 0;
            for (int j=1; j<n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            nums[idx] = nums[idx] * multiplier;
        }
        return nums;
    }
}
