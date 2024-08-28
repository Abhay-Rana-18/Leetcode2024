class Solution {
    boolean sub;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid2[i][j] == 1) {
                    sub = true;
                    recc(grid2, grid1, i, j, m, n);
                    if (sub) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public void recc(int[][]grid1, int[][]grid2, int i, int j, int m, int n) {
        if (i<0 || i>=m || j<0 || j>=n) {
            return;
        }
        if (grid1[i][j]==2 || grid1[i][j]==0) return;
        if (grid2[i][j] != 1) {
            sub = false;
        }
        grid1[i][j] = 2;
        recc(grid1, grid2, i+1, j, m, n);
        recc(grid1, grid2, i, j+1, m, n);
        recc(grid1, grid2, i-1, j, m, n);
        recc(grid1, grid2, i, j-1, m, n);
    }
}
