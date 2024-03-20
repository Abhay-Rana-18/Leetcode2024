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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ans = list1;
        int i1 = 0;
        while (i1<a-1) {
            list1 = list1.next;
            i1++;
        }

        ListNode temp = list1.next;
        list1.next = list2;
        while (i1<b) {
            temp = temp.next;
            i1++;
        }

        while (list2.next!=null) {
            list2 = list2.next;
        }

        list2.next = temp;

        return ans;
    }
}
