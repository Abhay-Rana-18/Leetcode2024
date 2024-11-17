class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n+1];

        // storing prefix
        for (int i=1; i<=n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        Deque<Integer> deque = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for (int i=0; i<=n; i++) {
            while (!deque.isEmpty() && prefixSum[i] >= prefixSum[deque.peekFirst()] + k) {
                min = Math.min(min, i-deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
