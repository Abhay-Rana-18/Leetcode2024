public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast==null || fast.next==null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow!=fast);

        return true;
    }
}
