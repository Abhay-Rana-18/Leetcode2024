class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for (int i=0; i+3<=rows; i++) {
            for (int j=0; j+3<=cols; j++) {
                int count = 0;
                boolean a = true;
                int sum = 0;

                // distinct numbers
                int[]arr = new int[10];
                for (int r=i; r<i+3; r++) {
                    for (int c=j; c<j+3; c++) {
                        if (grid[r][c] == 0 || grid[r][c] > 9) {
                            a = false;
                            break;
                        }
                        if(arr[grid[r][c]] == 1) {
                            a = false;
                            break;
                        }
                        arr[grid[r][c]] = 1;
                    }

                    if (!a) {
                        break;
                    }
                }
                if (!a) continue;

                // row
                for (int r=i; r<i+3; r++) {
                    int temp = 0;
                    for (int c=j; c<j+3; c++) {
                        if (grid[r][c] > 9) {
                            a = false;
                            break;
                        }
                        temp += grid[r][c];
                    }
                    if (sum == 0) {
                        sum = temp;
                    }
                    if (!a || temp!=sum) {
                        a = false;
                        break;
                    }
                }
                if (!a) continue;

                // column
                for (int c=j; c<j+3; c++) {
                    int temp = 0;
                    for (int r=i; r<i+3; r++) {
                        if (grid[r][c] > 9) {
                            a = false;
                            break;
                        }
                        temp += grid[r][c];
                    }


                    if (!a || temp!=sum) {
                        a = false;
                        break;
                    }
                }
                if (!a) continue;

                int temp = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                if (temp != sum) continue;
                

                temp = grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2];
                if (temp==sum) ans++;
            }
        }
        return ans;
    }
}
