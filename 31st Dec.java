class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return find(days, costs, dp, 0, 0, n);
    }

    private int find(int[] days, int[] costs, int[] dp, int i, int completed, int n) {
        if (i>=n) {
            return 0;
        }

        if (days[i]<=completed) {
            return find(days, costs, dp, i+1, completed, n);
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int day_1 = costs[0] + find(days, costs, dp, i+1, days[i], n);
        int day_7 = costs[1] + find(days, costs, dp, i+1, days[i]+6, n);
        int day_30 = costs[2] + find(days, costs, dp, i+1, days[i]+29, n);

        // System.out.println("i: "+i+", day_1: " +day_1+", day_7: "+day_7+", day_30: "+day_30);

        return dp[i] = Math.min(day_1, Math.min(day_7, day_30));
    }
}
