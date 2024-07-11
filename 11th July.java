class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        String ans = "";
        String str = "";
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            }
            else if(ch==')') {
                str = "";
                char c = stack.peek();
                while (!stack.isEmpty() && c!='(') {
                    str += c;
                    stack.pop();
                    c = stack.peek();
                }
                stack.pop();
               for (int j=0; j<str.length(); j++) {
                    stack.push(str.charAt(j));
               }
            }
            else {
                stack.push(ch);
            }
        }
        str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        for (int i=str.length()-1; i>=0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }
}
