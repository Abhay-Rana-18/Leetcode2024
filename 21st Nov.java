class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n];
        for (int[] a: walls) {
            mat[a[0]][a[1]] = -1;
        }

        for (int[] a: guards) {
            mat[a[0]][a[1]] = 3;
        }

        for (int[] guard: guards) {
            int row = guard[0];
            int col = guard[1];
            // up
            for (int j=row-1; j>=0; j--) {
                if (mat[j][col]==-1 || mat[j][col]==3) {
                    break;
                }
                mat[j][col] = 1;
            }

            // down
            for (int j=row+1; j<m; j++) {
                if (mat[j][col]==-1 || mat[j][col]==3) {
                    break;
                }
                mat[j][col] = 1;
            }

            // left
            for (int j=col-1; j>=0; j--) {
                if (mat[row][j]==-1 || mat[row][j]==3) {
                    break;
                }
                mat[row][j] = 1;
            }

            // right
            for (int j=col+1; j<n; j++) {
                if (mat[row][j]==-1 || mat[row][j]==3) {
                    break;
                }
                mat[row][j] = 1;
            }
        }

        int ans = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j]==0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
