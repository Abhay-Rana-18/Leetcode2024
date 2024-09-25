class Solution {
    class TrieNode {
        TrieNode child[];
        int ct;
        TrieNode() {
            ct = 0;
            child = new TrieNode[26];
        }
    }

    private void add(String word, TrieNode root) {
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.child[idx] == null) {
                root.child[idx] = new TrieNode();
            }
            root = root.child[idx];
            root.ct++;
        }
    }

    private int findSum(String word, TrieNode root) {
        int sum = 0;
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            root = root.child[idx];
            sum += root.ct;
        }
        return sum;
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        TrieNode root = new TrieNode();
        for (int i=0; i<n; i++) {
            add(words[i], root);
        }

        int []res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = findSum(words[i], root);
        }

        return res;
    }
}
