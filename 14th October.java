class Solution {
    public long maxKelements(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a, b) -> b-a);
        for (int i=0; i<n; i++) {
            pq.add(nums[i]);
        }
        long ans = 0;
        while (k>0) {
            int t = pq.poll();
            ans += t;
            pq.add((int)Math.ceil((double)t/3));
            k--;
        }

        return ans;
    }
}
