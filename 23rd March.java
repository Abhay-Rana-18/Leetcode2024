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
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode l1 = head;
        ListNode l2 = null;
        int mid = midLL(head);

        while (mid>1) {
            l1 = l1.next;
            mid--;
        }

        l2 = l1.next;
        l1.next = null;
        l1 = head;
        l2 = rev(l2);
        ListNode ptr1 = l1.next;
        ListNode ptr2 = l2.next;
        while (l1!=null && l2!=null) {
            l1.next = l2;
            l2.next = ptr1;

            l1 = ptr1;
            l2 = ptr2;

            if (ptr1!=null) {
                ptr1 = ptr1.next;
            }
            if (ptr2!=null) {
                ptr2 = ptr2.next;
            }
            
        }

        if (l2!=null) {
            // System.out.println(l2.val);
            // System.out.println(ptr2.val);
            l2.next = ptr1;
        }
        

        

    }

    public int midLL(ListNode head) {
        int len = 0;
        while (head!=null) {
            len++;
            head = head.next;
        }

        if (len%2!=0) {
            len += 1;
            len /= 2;
        } else {
            len /= 2;
        }

        return len;
    }

    public ListNode rev(ListNode node) {
        if (node==null || node.next==null) return node; 
        ListNode curr = node;
        ListNode prev = null;
        ListNode future = node.next;

        while(curr!=null) {
            curr.next = prev;
            prev = curr;
            curr = future;
            if (future!=null) {
                future = future.next;
            }
        }

        return prev;
    }
}
