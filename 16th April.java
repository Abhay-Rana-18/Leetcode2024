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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        if (depth==2) {
            TreeNode node1 = new TreeNode(val);
            TreeNode node2 = new TreeNode(val);
            node1.left = root.left;
            root.left = node1;
            node2.right = root.right;
            root.right = node2;
            return root;
        }

        if(root.left!=null) {
            root.left = addOneRow(root.left, val, depth-1);
        }
        if(root.right!=null) {
            root.right = addOneRow(root.right, val, depth-1);
        }

        return root;
    }
    
}
