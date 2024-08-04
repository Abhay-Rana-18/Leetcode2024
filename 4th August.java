class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = 1000000000 + 7;
        int len = (n*(n+1))/2;
        long[]arr = new long[len];
        int k = 0;
        long ans = 0;
        for (int i=0; i<n; i++) {
            long sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                arr[k++] = sum;
            }
        }

        Arrays.sort(arr);
        for (int i=left-1; i<right; i++) {
            ans += arr[i];
        }
        return (int)(ans%mod);
    }
}
