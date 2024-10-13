class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[]range = new int[2];
        range[0] = 0;
        range[1] = Integer.MAX_VALUE;

        PriorityQueue<int[]>pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            pq.add(new int[] {nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }

        while (true) {
            int[] minInfo = pq.poll();
            int min = minInfo[0];
            int row = minInfo[1];
            int col = minInfo[2];

            if ((max-min) < (range[1] - range[0])) {
                range[0] = min;
                range[1] = max;
            }

            if (col+1 < nums.get(row).size()) {
                pq.add(new int[] {nums.get(row).get(col+1), row, col+1});
                max = Math.max(max, nums.get(row).get(col+1));
            }
            else {
                break;
            }
        }
        return range;
    }
}
