class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            String str = arr[i];
            if (str.charAt(str.length()-1) != arr[i+1].charAt(0)) {
                return false;
            }
        }
        if (arr[n-1].charAt(arr[n-1].length()-1) != arr[0].charAt(0)) {
            return false;
        }
        return true;
    }
}
