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
        ListNode fast = head.next, slow = head;        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }        
        ListNode second = slow.next;
        ListNode prev = slow.next = null;        
        while(second!=null)
        {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }        
        ListNode temp1 = head, temp2 = prev;
        while(temp2!=null)
        {
            temp1 = temp1.next;
            temp2 = temp2.next;
            head.next = prev;
            prev.next = temp1;
            head = temp1;
            prev = temp2;
        }
    }
}
