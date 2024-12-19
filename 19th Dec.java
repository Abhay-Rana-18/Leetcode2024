class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int max = 0;
        for (int i=0; i<n; i++) {
            if (max<arr[i]) {
                max = arr[i];
            }
            if (max==i) {
                ans++;
            }
        }
        return ans;
    }
}
