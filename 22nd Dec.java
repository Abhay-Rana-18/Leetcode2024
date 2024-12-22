class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] result = new int[q];
        Arrays.fill(result, -1);
        List<List<int[]>> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i=0; i<q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a>b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a==b || heights[a]<heights[b]) {
                result[i] = b;
            }
            else {
                list.get(b).add(new int[]{ heights[a], i });
            }
        }

        for (int i=0; i<n; i++) {
            for (int[] a: list.get(i)) {
                pq.add(a);
            }
            while (!pq.isEmpty() && pq.peek()[0]<heights[i]) {
                result[pq.poll()[1]] = i;
            }
        }
        return result;
    }
}
