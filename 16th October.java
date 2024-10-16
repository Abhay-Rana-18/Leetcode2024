class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder("");
        int turns = a + b + c;
        while (turns>0) {
            int max = Math.max(a, Math.max(b, c));
            int n = ans.length();
            if (max == a) {
                if (n<2 || ans.charAt(n-1)!='a' || ans.charAt(n-2)!='a') {
                    ans.append('a');
                    a--;
                }
                else {
                    max = Math.max(b, c);
                    if (max == 0) {
                        break;
                    }
                    if (max == b) {
                        ans.append('b');
                        b--;
                    }
                    else {
                        ans.append('c');
                        c--;
                    }
                }
            }
            else if (max == b) {
                if (n<2 || ans.charAt(n-1)!='b' || ans.charAt(n-2)!='b') {
                    ans.append('b');
                    b--;
                }
                else {
                    max = Math.max(a, c);
                    if (max == 0) {
                        break;
                    }
                    if (max == a) {
                        ans.append('a');
                        a--;
                    }
                    else {
                        ans.append('c');
                        c--;
                    }
                }
            } 
            else {
                if (n<2 || ans.charAt(n-1)!='c' || ans.charAt(n-2)!='c') {
                    ans.append('c');
                    c--;
                }
                else {
                    max = Math.max(a, b);
                    if (max == 0) {
                        break;
                    }
                    if (max == a) {
                        ans.append('a');
                        a--;
                    }
                    else {
                        ans.append('b');
                        b--;
                    }
                }
            }
            turns--;
        }
        return ans.toString();
    }
}
