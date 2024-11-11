class Solution {
    private boolean isPrime(int num) {
        if (num<2) return false;
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int bound = (i==0) ? nums[0] : nums[i] - nums[i-1];
            if (bound <= 0) return false;
            for (int j=bound-1; j>=2; j--) {
                if (isPrime(j)) {
                    nums[i] -= j;
                    break;
                }
            }
        }
        return true;
    }
}
