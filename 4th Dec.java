class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int i1 = 0;
        int i2 = 0;
        if (n2>n1) {
            return false;
        }
        while (i2<n2) {
            char ch1 = str2.charAt(i2);
            char ch2 = (char)(str2.charAt(i2)-1);
            if (ch1=='a') {
                ch2 = 'z';
            }
            while(i1<n1) {
                if (str1.charAt(i1) == ch1 || str1.charAt(i1) == ch2) {
                    break;
                }
                i1++;
            }
            if (i1==n1) {
                return false;
            }
            i2++;
            i1++;
        }
        return i2==n2;
    }
}
