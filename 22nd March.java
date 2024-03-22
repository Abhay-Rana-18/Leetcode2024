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
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) return true;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        // calculate length
        ListNode temp = head;
        int length = 0;
        while (temp!=null) {
            temp = temp.next;
            length++;
        }

        boolean isOdd = false;
        if (length%2!=0) isOdd = true;
        length /= 2;
        temp = head;
        while (length>0) {
            first.add(temp.val);
            temp = temp.next;
            length--;
        }

        if (isOdd) {
            temp = temp.next;
        }
        
        while (temp!=null) {
            second.add(temp.val);
            temp = temp.next;
        }

        Collections.reverse(first);
        // System.out.println(first);
        // System.out.println(second);
        return first.equals(second);
    }
}
