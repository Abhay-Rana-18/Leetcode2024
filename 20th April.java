class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> lst = new ArrayList<>();

        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j]==1) {
                    int[]coordinates = findPoints(land, i, j);
                    lst.add(coordinates);
                }
            }
        }

        return lst.toArray(new int[lst.size()][]);
    }

    private int[] findPoints(int[][]land, int row, int col) {
        int[] ans = new int[4];
        ans[0] = row;
        ans[1] = col;
        int m = land.length;
        int n = land[0].length;
        int r = row;
        int c = col;
        while (r<m && land[r][col]==1) {
            r++;
        }
        while (c<n && land[row][c]==1) {
            c++;
        }

        ans[2] = r-1;
        ans[3] = c-1;
        for (int i=row; i<r; i++) {
            for (int j=col; j<c; j++) {
                land[i][j] = 0;
            }
        }

        return ans;
    }
}
