class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int []ans = new int[n1];
        Arrays.sort(arr1);
        for (int i=0; i<n1; i++) {
            int element = arr1[i];
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            } else {
                map.put(element, 1);
            }
        }
        int index = 0;
        for (int i=0; i<n2; i++) {
            int count = map.get(arr2[i]);
            while (count>0) {
                ans[index++] = arr2[i];
                count--;
            }
            map.put(arr2[i], 0);
        }

        for (int i=0; i<n1; i++) {
            int count = map.get(arr1[i]);
            while (count>0) {
                ans[index++] = arr1[i];
                count--;
            }
            map.put(arr1[i], 0);
        }

        return ans;
    }
}
