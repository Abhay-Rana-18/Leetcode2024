class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            ans[i] = nums[i];
        }
        Arrays.sort(ans);
        if (Arrays.equals(nums, ans)) {
            return true;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-1; j++) {
                if (Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1]) && nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return Arrays.equals(nums, ans);

    }
}
