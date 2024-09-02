class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int count = 0;
        for (int i=0; i<n; i++) {
            if (chalk[i]>k) {
                return i;
            }
            k -= chalk[i];
            if (i==n-1) {
                i = -1;
            }
        }
        return 0;
    }
}
