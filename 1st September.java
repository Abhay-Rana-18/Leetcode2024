class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        int[][]ans = new int[m][n];
        if (m*n != len) return new int[][]{};
        int s = 0;
        int e = 0;
        for (int i=0; i<len; i++) {
            if (s==m) break;
            ans[s][e++] = original[i];
            if (e==n) {
                s++;
                e = 0;
            }
        }

        return ans;
    }
}
