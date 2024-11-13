class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower-1);
    }

    public long count(int[] nums, int value) {
        int l = 0;
        int r = nums.length - 1;
        long c = 0;
        while(l<r) {
            if (nums[l] + nums[r] <= value) {
                c+=r-l;
                l++;
            }
            else {
                r--;
            }
        }
        return c;
    }
}
