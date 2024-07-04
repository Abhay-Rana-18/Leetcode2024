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
    public ListNode mergeNodes(ListNode head) {
        ListNode node = head.next;
        int sum = 0;
        ListNode ans=null;
        ListNode h2=null;
        while (node!=null) {
            if (node.val == 0) {
                if (ans == null) {
                    ans = new ListNode(sum);
                    h2 = ans;
                }
                else {
                    ans.next = new ListNode(sum);
                    ans = ans.next;
                }
                sum = 0;
            }
            else {
                sum += node.val;
            }
            node = node.next;
        }
        return h2;
    }
}
