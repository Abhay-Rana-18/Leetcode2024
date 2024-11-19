class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        if (k>n || k==0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int e = k;
        long sum = 0;
        int c = 0;
        for (int i=0; i<k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
                c++;
            }
            else {
                map.put(nums[i], 1);
            }
            sum += nums[i];
        }
        if (c==0) {
            ans = Math.max(sum, ans);
        }
        
        while (e<n) {
            if (map.get(nums[s])>1) {
                map.put(nums[s], map.get(nums[s])-1);
                c--;
            }
            else {
                map.remove(nums[s]);
            }
            sum -= nums[s];
            if (map.containsKey(nums[e])) {
                map.put(nums[e], map.get(nums[e])+1);
                c++;
            }
            else {
                map.put(nums[e], 1);
            }
            sum += nums[e];
            s++;
            e++;
            if (c==0) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}
