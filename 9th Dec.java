class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n = nums.length;
        int[] prefix = new int[n];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1];
            if (nums[i]%2 == nums[i-1]%2) {
                prefix[i]++;
            }
        }
        // System.out.println(Arrays.toString(prefix));
        int count = 0;
        for (int[] q: queries) {
            int from = q[0];
            int to = q[1];
            ans[count++] = (prefix[to]==prefix[from]);
        }
        return ans;
    }
}
