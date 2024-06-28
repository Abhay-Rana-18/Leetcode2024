class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[]arr = new int[n];
        int len = roads.length;

        for (int i=0; i<len; i++) {
            arr[roads[i][0]]++;
            arr[roads[i][1]]++;
        }

        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        long maxSum = 0;
        long num = 1;
        for (int i=0; i<n; i++) {
            maxSum += (num * arr[i]);
            num++;
        }

        return maxSum;
    }
}
