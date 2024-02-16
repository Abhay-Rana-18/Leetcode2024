class Solution {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        int[]numbers = new int[arr.length];
        Arrays.sort(arr);
        int n = 0;
        numbers[0] = 1;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]==arr[i-1]) {
                numbers[n]++;
            }
            else {
                numbers[++n]++;
            }
        }
        
        Arrays.sort(numbers);
        for (int j=0; j<numbers.length; j++) {
            if (k<numbers[j]) {
                return numbers.length - j;
            }
            k -= numbers[j];
        }
        

        return 0;

    }
}
