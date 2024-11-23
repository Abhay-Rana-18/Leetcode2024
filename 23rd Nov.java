class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] ans = new char[n][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                ans[j][m-1-i] = box[i][j];
            }
        }

        for (int i=n-1; i>=0; i--) {
            for (int j=m-1; j>=0; j--) {
                if (ans[i][j]=='#') {
                    int r = i+1;
                    while (r<n && ans[r][j]=='.') {
                        r++;
                    }
                    r--;
                    if (r!=i) {
                        ans[i][j] = '.';
                        ans[r][j] = '#';
                    }
                }
            }
        }

        return ans;
    }
}
