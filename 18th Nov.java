class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k==0) {
            return ans;
        }
        
        for (int i=0; i<n; i++) {
            int s = 0;
            if (k>0) {
                for (int j=0; j<k; j++) {
                    s += code[(i+1+j)%n];
                }
            }
            if (k<0) {
                for (int j=0; j<(-k); j++) {
                    int idx = (i-1-j)%n;
                    if (idx<0) {
                        idx = n+idx;
                    }
                    s += code[idx];
                }
            }
            ans[i] = s;
        }

        return ans;
    }
}
