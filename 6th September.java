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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return head;
        Map<Integer, Integer>map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], 1);
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null) {
            if (map.containsKey(curr.val)) {
                if (prev != null) {
                    prev.next = next;
                    curr = next;
                    if (next != null) {
                        next = next.next;
                    }
                }
                else {
                    head = next;
                    curr = next;
                    if (next != null) {
                        next = next.next;
                    }
                }
                
            }
            else {
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
            }
        }

        return head;
    }
}
