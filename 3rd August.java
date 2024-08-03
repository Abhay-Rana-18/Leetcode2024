class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i=0; i<n; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        
        return true;
    }
}
