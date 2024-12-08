class Solution {
    public int maxTwoEvents(int[][] events) {
         Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;
        int ans = 0;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];  
        for (int i = n - 2; i >= 0; --i) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            pq.add(events[i]);
            ans = Math.max(ans, events[i][2]);

            while (!pq.isEmpty() && pq.peek()[1] < events[i][0]) {
                int[] previousEvent = pq.poll();
                ans = Math.max(ans, previousEvent[2] + suffixMax[i]);
            }
        }

        return ans;
    }
}
