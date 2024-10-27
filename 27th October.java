class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;
        for (int r=1; r<rows; r++) {
            for (int c=1; c<cols; c++) {
                if (matrix[r][c] == 1) {
                    matrix[r][c] += Math.min(matrix[r][c-1], Math.min(matrix[r-1][c], matrix[r-1][c-1]));
                }
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                ans += matrix[i][j];
            }
        }

        return ans;
    }
}
