class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Map<String, Integer>map = new HashMap<>();
        for (int i=0; i<dictionary.length; i++) {
            map.put(dictionary[i], 1);
        }
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return n - compute(s, map, 0, n, dp);
    }

    private int compute(String s, Map<String, Integer>map, int start, int n, int[]dp) {
        if (dp[start] != -1) {
            return dp[start];
        }
        int max = 0;
        for (int i=start; i<n; i++) {
            if (map.containsKey(s.substring(start, i+1))) {
                max = Math.max(max, i+1-start+compute(s, map, i+1, n, dp));
            }
            else {
                max = Math.max(max, compute(s, map, i+1, n, dp));
            }
        }
        return dp[start] = max;
    }
}
