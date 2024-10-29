class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for (int i=0; i<rows; i++) {
            int a = helper(grid, i, 0, 0, rows, cols, dp);
            ans = Math.max(ans, a);
        }
        return ans;
    }

    public int helper(int[][] grid, int r, int c, int moves, int rows, int cols, int[][] dp) {
        if (dp[r][c] > -1) return dp[r][c];
        int a=0, b=0, d=0;

        if (r-1>=0 && c+1<cols && grid[r][c]<grid[r-1][c+1]) {
            a = helper(grid, r-1, c+1, moves+1, rows, cols, dp);
        }
        if (c+1<cols && r+1<rows && grid[r][c]<grid[r+1][c+1]) {
            b = helper(grid, r+1, c+1, moves+1, rows, cols, dp);
        }
        if (c+1<cols && grid[r][c]<grid[r][c+1]) {
            d = helper(grid, r, c+1, moves+1, rows, cols, dp);
        }
        return dp[r][c] = Math.max(a, Math.max(b, Math.max(moves, d)));
        
    }
}
