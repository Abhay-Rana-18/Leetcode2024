class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] freq = new int[10];
        for (int i=0; i<arr.length; i++) {
            freq[arr[i] - '0'] = i;
        }
        for (int i=0; i<arr.length; i++) {
            for (int j=9; j>arr[i]-'0'; j--) {
                if (freq[j] > i) {
                    char temp = arr[i];
                    arr[i] = arr[freq[j]];
                    arr[freq[j]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
