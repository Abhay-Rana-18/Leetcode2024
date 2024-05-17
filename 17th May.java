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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (traversal(root, target)) {
            return null;
        }
        return root;
    }

    private boolean traversal(TreeNode node, int target) {
        if (node==null) {
            return false;
        }

        if (node.val==target) {
            if (node.left==null && node.right==null) {
                return true;
            }
            else if (node.left!=null && node.right!=null) {
                if (node.left.val == target && node.right.val==target) {
                    if (traversal(node.left, target) && traversal(node.right, target)) {
                        return true;
                    }
                }
            }

            else if (node.left!=null && node.left.val==target) {
                if (traversal(node.left, target)) {
                    return true;
                }
                return false;
            }

            else if(node.right!=null && node.right.val==target) {
                if (traversal(node.right, target)) {
                    return true;
                }
                return false;
            }
        }

        if (node.left!=null) {
            if (traversal(node.left, target)) {
                node.left = null;
            }
        }

        if (node.right!=null) {
            if (traversal(node.right, target)) {
                node.right = null;
            }
        }   

        return false;     
        
    }
}
