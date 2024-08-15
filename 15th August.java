class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int[]changes = new int[21];
        for (int i=0; i<n; i++) {
                changes[bills[i]]++;
                while ((bills[i]-5) >= 20 && changes[20]>0) {
                    changes[20]--;
                    bills[i]-=20;
                }
                while ((bills[i]-5) >= 15 && changes[15]>0) {
                    changes[15]--;
                    bills[i]-=15;
                }
                while ((bills[i]-5) >= 10 && changes[10]>0) {
                    changes[10]--;
                    bills[i]-=10;
                }
                while ((bills[i]-5) >= 5 && changes[5]>0) {
                    changes[5]--;
                    bills[i]-=5;
                }
            if (bills[i]>5) {
                return false;
            }
        }
        return true;
    }
}
