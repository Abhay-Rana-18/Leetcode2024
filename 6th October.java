import java.util.Stack;

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        String s1[] = sentence1.split(" ");
        String s2[] = sentence2.split(" ");

        for (int i = 0; i < s1.length; i++) {
            stack1.push(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            stack2.push(s2[i]);
        }

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().equals(stack2.peek())) {
            stack1.pop();
            stack2.pop();
        }

        int i = 0;
        int len1 = stack1.size(); // unmatched words jo present hai
        int len2 = stack2.size();

        while (i < len1 && i < len2 && s1[i].equals(s2[i])) {
            i++;
        }
        return (i==len1 || i==len2);    // return logic improved by Deepanshu
}
}
