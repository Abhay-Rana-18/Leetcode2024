class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int i=0; i<m; i++) {
            sum += rolls[i];
        }
        sum = (mean * (m+n)) - sum;
        int[]ans = new int[n];
        int avg = sum/n;
        // System.out.println("sum: "+sum);
        sum -= n;
        if (sum<0 || avg > 6 || avg<0) {
            return new int[]{};
        }
        // System.out.println("sum: "+sum);
        for (int i=0; i<n; i++) {
            if (i==n-1 && sum > 5) {
                return new int[]{};
            }
            if (sum == 0) {
                ans[i] = 1;
                continue;
            }
            if (sum < 5) {
                ans[i] = sum + 1;
                sum = 0;
                continue;
            }
            ans[i] = 6;
            sum -= 5;
        }
        return ans;
    }
}
