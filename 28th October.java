class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Set<Integer>set = new HashSet<>();
        Arrays.sort(nums);
        int end = nums[n-1];
        for (int i=0; i<n; i++) {
            set.add(nums[i]);
        }
        int ans= 0;
        for (int i=0; i<n; i++) {
            int e = nums[i];
            int count = 1;
            if (e*e > end) {
                break;
            }
            while (set.contains(e*e)) {
                count++;
                e = e*e;
            }
            ans = Math.max(count, ans);
        }
        if (ans<=1) {
            return -1;
        }
        return ans;
    }
}
