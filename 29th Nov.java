class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.add(new int[]{0, 0, 0});
        if (grid[0][1]>1 && grid[1][0]>1) {
            return -1;
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int row = arr[0];
            int col = arr[1];
            int time = arr[2];
            if (vis[row][col]) continue;
                
            if (row==m-1 && col==n-1) {
                return time;
            }
            vis[row][col] = true;

            for (int[] dir: directions) {
                int nr = row+dir[0];
                int nc = col+dir[1];
                
                if (nr>=0 && nc>=0 && nr<m && nc<n) {
                    if (vis[nr][nc]) continue;
                    int cycle = ((grid[nr][nc]-time)%2==0) ? 1 : 0;
                    int nt = Math.max(grid[nr][nc]+cycle, time+1);
                    pq.add(new int[]{nr, nc, nt}); 
                }
            }
        }
        
        return -1;
        
    }
}
