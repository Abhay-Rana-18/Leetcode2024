/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        fun(root);
        return ans;
    }

    public void fun(Node node) {
        if (node == null) {
            return;
        }
        List<Node>lst = node.children;
        for (int i=0; i<lst.size(); i++) {
            fun(lst.get(i));
        }

        ans.add(node.val);
    }
}
