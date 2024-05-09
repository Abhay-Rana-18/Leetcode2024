class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int i = happiness.length-1;
        int j = 0;
        while (k>0) {
            if (happiness[i]>j) {
                ans += happiness[i]-j;
            }
            j++;
            k--;            
            i--;
        }

        return ans;
    }
}
