/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        q.add(root);
        boolean odd = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (odd) {
                    int rep = st.pop();
                    node.val = rep;
                }
                if (node.left!=null) {
                    q.add(node.left);
                    q.add(node.right);
                }
                if (node.left!=null && !odd) {
                    temp.add(node.left.val);
                    temp.add(node.right.val);
                }
            }
            while (!temp.isEmpty()) {
                st.add(temp.poll());
            }
            odd = !odd;
        }
        return root;
    }
}
