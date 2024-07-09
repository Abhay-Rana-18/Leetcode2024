class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double sum = 0;
        if (n==0) {
            return 0;
        }
        int time = customers[0][0];
        for (int i=0; i<n; i++) {
            if (time<customers[i][0]) {
                sum += customers[i][1];
                time = customers[i][0] + customers[i][1];
            }
            else {
                time += customers[i][1];
                sum += time-customers[i][0];
            }
        }

        return sum/n;
    }
}
