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
    public ListNode middleNode(ListNode head) {
        int len = findLen(head);
        int mid = len/2;
        int i = 1;
        while(i<=mid) {
            head = head.next;
            i++;
        }

        return head;
    }
    public int findLen(ListNode node) {
        int len = 0;
        while (node!=null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
