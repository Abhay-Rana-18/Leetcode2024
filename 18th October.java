class Solution {
    int[] arr;
    int max = 0;
    public int countMaxOrSubsets(int[] nums) {
        this.arr = nums;
        for (int e: arr) {
            max = max | e;
        }
        if (max == 0) {
            return (int)Math.pow(2, arr.length);
        }
        return helper(0, 0);
    }

    public int helper(int val, int idx) {
        if (val == max) {
            int rem = arr.length - idx;
            return (int) Math.pow(2, rem);
        }
        if (idx == arr.length && val!=max) {
            return 0;
        }
        return helper(val|arr[idx], idx+1) + helper(val, idx+1);
    }
}
