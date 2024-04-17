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
    String ans = "";
    public String smallestFromLeaf(TreeNode root) {
        traverse(root, new StringBuilder());
        return ans;
    }

    private void traverse(TreeNode node, StringBuilder str) {
        if  (node==null) return;
        str.append((char)('a' + node.val));
        if (node.left==null && node.right==null) {
            String newStr = str.reverse().toString();
            if (newStr.compareTo(ans)<0 || ans.length()==0) {
                ans = str.toString();
            }
            str.reverse();
        }

        traverse(node.left, str);
        traverse(node.right, str);
        
        str.setLength(str.length()-1);
    }
}
