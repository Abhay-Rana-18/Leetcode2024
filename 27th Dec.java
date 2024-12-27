class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int left = values[0];
        for (int right = 1; right<values.length; right++) {
            int score = left + values[right] - right;
            ans = Math.max(ans, score);
            left = Math.max(left, right+values[right]);
        }
        
        return ans;
    }
}
