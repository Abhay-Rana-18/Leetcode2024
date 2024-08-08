class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][]ans = new int[rows*cols][2];
        int idx = 0;
        ans[idx++] = new int[]{rStart, cStart++};
        if (cStart<cols && rStart<rows) {
            ans[idx++] = new int[]{rStart, cStart};
        }
        
        for (int i=1; i<100000; i+=2) {
            // down
            for (int j=0; j<i; j++) {
                rStart++;
                if (rStart>=0 && cStart>=0 && cStart<cols && rStart<rows && idx<rows*cols) {
                    ans[idx++] = new int[]{rStart, cStart};
                }
            }
            if (idx == rows*cols) break;

            // left
            for (int c=0; c<=i; c++) {
                cStart--;
                if (rStart>=0 && cStart>=0 && cStart<cols && rStart<rows && idx<rows*cols) {
                    ans[idx++] = new int[]{rStart, cStart};
                }
            }
            if (idx == rows*cols) break;

            // up
            for (int r=0; r<=i; r++) {
                rStart--;
                if (rStart>=0 && cStart>=0 && cStart<cols && rStart<rows && idx<rows*cols) {
                    ans[idx++] = new int[]{rStart, cStart};
                }
            }
            if (idx == rows*cols) break;

            // right
            for (int c=0; c<=i+1; c++) {
                cStart++;
                if (rStart>=0 && cStart>=0 && cStart<cols && rStart<rows && idx<rows*cols) {
                    ans[idx++] = new int[]{rStart, cStart};
                }
            }
            if (idx == rows*cols) break;
        }

        return ans;
    }
}
