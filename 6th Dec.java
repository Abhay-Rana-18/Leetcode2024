class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int e: banned) {
            set.add(e);
        }
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (set.contains(i)) continue;
            if (sum+i<=maxSum) {
                sum += i;
                ans++;
            }
        }
        return ans;
    }
}
