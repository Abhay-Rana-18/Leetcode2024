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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n==0) return head;
        ListNode temp = head;
        int size = 0;
        while (temp!=null) {
            size++;
            temp = temp.next;
        }
        int rem = size-n;
        temp = head;
        if (rem==0) {
            return head.next;
        }
        while (rem!=1) {
            temp = temp.next;
            rem--;
        }
        if (temp.next!=null) {
            temp.next = temp.next.next;
        }

        return head;
        
    }
}
