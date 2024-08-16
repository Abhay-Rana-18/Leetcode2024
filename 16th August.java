class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int ans = 0;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min2 = arrays.get(1).get(0);
        int max2 = arrays.get(1).get(arrays.get(1).size()-1);
        int iMax = 0;
        int iMin = 0;
        for (int i = 1; i < n; i++) {
            if (arrays.get(i).get(0) < min) {
                min2 = min;
                min = arrays.get(i).get(0);
                iMin = i;
            }
            else {
                 if (arrays.get(i).get(0) < min2) {
                    min2 = arrays.get(i).get(0);
                }
            }
            if (arrays.get(i).get(arrays.get(i).size() - 1) > max) {
                max2 = max;
                max = arrays.get(i).get(arrays.get(i).size() - 1);
                iMax = i;
            }
           else {
            if (arrays.get(i).get(arrays.get(i).size() - 1) > max2) {
                max2 = arrays.get(i).get(arrays.get(i).size() - 1);
            }
           }
        }
        if (iMin == iMax) {
            int temp = Math.max(max - min2, max2 - min);
            ans = Math.max(ans, temp);
        } else {
            ans = Math.max(ans, max - min);
        }
        // System.out.println("max: " + max + ", min: " + min);
        // System.out.println("max2: " + max2 + ", min2: " + min2);

        return ans;
    }
}
