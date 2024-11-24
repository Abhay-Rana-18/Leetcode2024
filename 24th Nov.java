class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int neg = 0;
        boolean zero = false;
        int min = Integer.MAX_VALUE;
        for (int[] r: matrix) {
            for(int e: r) {
                if (e==0) {
                    zero = true;
                }
                else if(e<0) {
                    neg++;
                    e = -e;
                }
                ans += e;
                min = Math.min(min, e);
            }
        }
        if (zero || neg%2==0) {
            return ans;
        }
        return ans-(2*min);
    }
}
