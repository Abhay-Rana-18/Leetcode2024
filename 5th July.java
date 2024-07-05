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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) {
            return new int[]{-1, -1};
        }
        int maxDis;
        int minDis;
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int count = 2;
        List<Integer>lst = new ArrayList<>();
        while (next!=null) {
            if (curr.val < prev.val && curr.val < next.val) {
                lst.add(count);
            } 
            else if (curr.val > prev.val && curr.val > next.val) {
                lst.add(count);
            }
            count++;
            prev = curr;
            curr = next;
            next = next.next;
        }
        Collections.sort(lst);
        int n = lst.size();
        if (n<2) {
            return new int[]{-1, -1};
        }
        maxDis = lst.get(n-1) - lst.get(0);
        minDis = maxDis;
        for (int i=1; i<n; i++) {
            minDis = Math.min(minDis, lst.get(i)-lst.get(i-1));
        }
        return new int[]{minDis, maxDis};
    }
}
