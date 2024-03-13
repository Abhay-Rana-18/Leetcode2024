class Solution {
    public int pivotInteger(int n) {
        int mid = n/2;
        int sum1 = 0;
        int sum2 = 0;
        for (int i=1; i<=mid; i++) {
            sum1 += i;
        }
        for (int j=mid; j<=n; j++) {
            sum2 += j;
        }

        while (sum1<=sum2) {
            if (sum1 == sum2) {
                return mid;
            }
            sum2 -= mid;
            mid += 1;
            sum1 += mid;
        }

        return -1;
    }
}
