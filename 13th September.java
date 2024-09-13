class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[]pre = new int[arr.length];
        pre[0] = arr[0];
        int[]ans = new int[n];
        for (int i=1; i<arr.length; i++) {
            pre[i] = pre[i-1] ^ arr[i];
        }
        for (int i=0; i<n; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            if (first == 0) {
                ans[i] = pre[second];
            }
            else {
                ans[i] = pre[second] ^ pre[first-1];
            }
        }
        return ans;
    }
}
