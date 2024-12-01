class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i=0; i<n; i++) {
            map.put(arr[i]*2, map.getOrDefault(arr[i]*2, 0)+1);
        }
        for (int i=0; i<n; i++) {
            if (map.containsKey(arr[i])) {
                if (arr[i]==0) {
                    if (map.get(0)>1) {
                        return true;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }
}
