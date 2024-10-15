class Solution {
    public long minimumSteps(String s) {
        int n = s.length();
        int right = n;
        long ans = 0;
        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '1') {
                ans += (right-1)-i;
                right--;
            }
        }

        return ans;
    }
}
