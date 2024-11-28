class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        int[][] vis = new int[m][n];
        for(int[] arr: vis) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        int [][]traverse = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int rem = curr[2];
            if (row==m-1 && col==n-1) {
                return rem;
            }
            for (int[] arr: traverse) {
                int nr = arr[0] + row;
                int nc = arr[1] + col;
                if (nr>=0 && nr<m && nc>=0 && nc<n) {
                    int nRem = rem + grid[nr][nc];
                    if (vis[nr][nc]>nRem) {
                        vis[nr][nc] = nRem;
                        if (grid[row][col]==1) {
                            queue.addLast(new int[]{nr, nc, nRem});
                        }
                        else {
                            queue.addFirst(new int[] {nr, nc, nRem});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
