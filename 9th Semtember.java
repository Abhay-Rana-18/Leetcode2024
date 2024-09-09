/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
    approach - 1


    iterate it with spiral, first a code 
    
    
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        spiralMatrixUtil(matrix, 0, 0, m, n, head);
        return matrix;
    }

    private void spiralMatrixUtil(int[][] matrix, int rowStart, int colStart, int rowEnd, int colEnd, ListNode node) {
        int i;

        // Base condition: If rowStart or colStart exceed bounds, stop recursion
        if (rowStart >= rowEnd || colStart >= colEnd) {
            return;
        }

        // Fill top row (left to right)
        for (i = colStart; i < colEnd; i++) {
            if (node != null) {
                matrix[rowStart][i] = node.val;
                node = node.next;
            } else {
                matrix[rowStart][i] = -1;
            }
        }

        // Fill right column (top to bottom)
        for (i = rowStart + 1; i < rowEnd; i++) {
            if (node != null) {
                matrix[i][colEnd - 1] = node.val;
                node = node.next;
            } else {
                matrix[i][colEnd - 1] = -1;
            }
        }

        // Fill bottom row (right to left) if needed
        if (rowStart < rowEnd - 1) {
            for (i = colEnd - 2; i >= colStart; i--) {
                if (node != null) {
                    matrix[rowEnd - 1][i] = node.val;
                    node = node.next;
                } else {
                    matrix[rowEnd - 1][i] = -1;
                }
            }
        }

        // Fill left column (bottom to top) if needed
        if (colStart < colEnd - 1) {
            for (i = rowEnd - 2; i > rowStart; i--) {
                if (node != null) {
                    matrix[i][colStart] = node.val;
                    node = node.next;
                } else {
                    matrix[i][colStart] = -1;
                }
            }
        }

        // Recur for the inner submatrix
        spiralMatrixUtil(matrix, rowStart + 1, colStart + 1, rowEnd - 1, colEnd - 1, node);
    }

}
