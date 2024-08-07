class Solution {
    public String kthDistinct(String[] arr, int k) {
        if (k==0) return new String("");
        Map<String, Integer>map = new HashMap<>();
        int n = arr.length;

        for (int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int i=0; i<n; i++) {
            if (map.get(arr[i]) == 1) {
                k--;
            }
            if (k==0) {
                return arr[i];
            }
        }
        return new String("");
    }
}