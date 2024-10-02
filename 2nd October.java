class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[]temp = new int[n];
        for (int i=0; i<n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int[]ans = new int[n];
        int rank = 1;
        Map<Integer, Integer>map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put(temp[i], rank);
            if (i<n-1 && temp[i+1]!=temp[i]) {
                rank++;
            }
        }

        for (int i=0; i<n; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
