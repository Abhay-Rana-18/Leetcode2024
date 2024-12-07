class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 1;
        int high = nums[n-1];
        int ans = high;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (canDis(nums, mid, maxOperations)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canDis(int[] nums, int max, int maxOperations) {
        int op = 0;
        for (int i=nums.length-1; i>=0; i--) {
            if (max > nums[i]) {
                break;
            }
            op += (nums[i]-1)/max;
            if (op>maxOperations) {
                return false;
            }
        }
        return true;
    }
}
