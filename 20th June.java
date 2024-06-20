class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int lo = 1;
        int hi = (position[n-1] - position[0])/(m-1);
        int ans = -1;
        while (lo<=hi) {
            int mid = (lo+(hi-lo)/2);
            if (canPlace(position, mid, m)) {
                lo = mid+1;
                ans = mid;
            }
            else {
                hi = mid-1;
            }
        }
        return ans;
    }

    private boolean canPlace(int[]arr, int diff, int m) {
        int count = 1;
        int last = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]-last>=diff) {
                count++;
                last = arr[i];
            }
            if (count>=m) {
                return true;
            }
        }
        return false;
    }
}
