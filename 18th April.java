class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length==0) {
            return 0;
        }
        int peri  = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (grid[i][j] == 1) {
                    if(i==0) {
                        peri++;
                    }
                    else {
                        if (grid[i-1][j]==0) {
                            peri++;
                        }
                    }
                    if (i==r-1) {
                        peri++;
                    }
                    else {
                        if (grid[i+1][j]==0) {
                            peri++;
                        }
                    }

                    if (j==0) {
                        peri++;
                    }
                    else {
                        if (grid[i][j-1]==0) {
                            peri++;
                        }
                    }
                    if (j==c-1) {
                        peri++;
                    }
                    else {
                        if (grid[i][j+1]==0) {
                            peri++;
                        }
                    }
                }
            }
        }

        return peri;
    }
}
