class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(
            ((b[0]+1.0)/(b[1]+1.0) - b[0]/b[1]),
            ((a[0]+1.0)/(a[1]+1.0) - a[0]/a[1])
        ));
        int n = classes.length;
        for (int[] c: classes) {
            pq.add(new double[]{(double)c[0], (double)c[1]});
        }
        while (extra>0 && !pq.isEmpty()) {
            double[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.add(new double[]{c[0], c[1]});
            extra--;
        }
        double ans = 0.0;
        while (!pq.isEmpty()) {
            double[] arr = pq.poll();
            ans += arr[0]/arr[1];
        }
        // System.out.println(ans);
        return ans/(double)n;
    }
}
