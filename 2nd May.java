class Solution {
    public int findMaxK(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = n-1;
        while (start<end) {
            if (nums[end] == 0 - nums[start]) {
                return nums[end];
            }
            else if(nums[end]>0-nums[start]) {
                end--;
            }
            else {
                start++;
            }
        }

        return -1;
        
    }
}
