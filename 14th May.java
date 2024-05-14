class Solution {
    public int ans = 0;
    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] != 0) {
                    backtrack(grid, i, j, 0);                
                }
            }
        }

        return ans;
    }

    private void backtrack(int[][]grid, int row, int col, int sum) {       
        if (grid[row][col]==0) {
            ans = Math.max(ans, sum);
            return;
        }
        int curr = grid[row][col];
        sum += curr;
        grid[row][col] = 0;

        // up
        if (row>0) {
            backtrack(grid, row-1, col, sum);
        }
        // down
        if (row<grid.length-1) {
            backtrack(grid, row+1, col, sum);
        }
        // right
        if (col<grid[0].length-1) {
            backtrack(grid, row, col+1, sum);
        }
        // left
        if (col>0) {
            backtrack(grid, row, col-1, sum);
        }

        grid[row][col] = curr;
    }
}
