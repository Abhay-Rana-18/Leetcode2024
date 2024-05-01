class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder("");
        int index = word.indexOf(ch);
        if (index==-1) return word;
        sb.append(word.substring(0, index+1));
        sb.reverse();
        System.out.println(sb);
        return sb.toString() + word.substring(index+1, word.length());
    }
}
