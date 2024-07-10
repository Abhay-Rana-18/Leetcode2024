class Solution {
    public int minOperations(String[] logs) {
        int n = logs.length;
        int count = 0;
        for (int i=0; i<n; i++) {
            String str = logs[i];
            if (str.equals("../")) {
                if (count>0) {
                    count--;
                }
            }
            else if(str.equals("./")) {}
            else {
                count++;
            }
        }
        return count;
    }
}
