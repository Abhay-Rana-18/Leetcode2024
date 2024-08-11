class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // Step 1: Check if the grid is already disconnected.
        if (isDisconnected(grid)) return 0;
        
        // Step 2: Check if we can disconnect the island by removing one cell.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (isDisconnected(grid)) return 1;
                    grid[i][j] = 1;  // Revert back to land.
                }
            }
        }
        
        // Step 3: If not possible in 1 day, return 2.
        return 2;
    }
    
    // Helper method to check if the grid is disconnected
    private boolean isDisconnected(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (islandCount > 0) return true; // More than one island
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        
        return islandCount != 1; // Return true if 0 or more than 1 island.
    }
    
    // Depth-First Search (DFS) to mark connected land.
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) return;
        
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
