class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int counter1 = 0;
        int counter2 = n-1;
        char temp;
        while (counter2>counter1) {
            temp = s[counter1];
            s[counter1] = s[counter2];
            s[counter2] = temp;
            counter1++;
            counter2--;
        }

    }
}
