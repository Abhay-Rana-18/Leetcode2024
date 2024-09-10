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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode temp = head;
        ListNode next = head.next;
        while (temp!=null && temp.next!=null) {
            int g = gcd(temp.val, temp.next.val);
            ListNode x = new ListNode(g);
            x.next = temp.next;
            temp.next = x;
            temp = x.next;
        }

        return head;
    }

     public int gcd(int a, int b){
        if(a == 1 || b==1){
            return 1;
        }
        while(b !=0){
            int rem = a % b;
            a = b;
            b= rem;
        }
        return a;
    }
}
