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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while(len < k){
		    if(cur == null){
                return head;
            }
            cur = cur.next;
            len++;
        }
		ListNode newHead = this.reserveList(head, k);
		head.next = this.reverseKGroup(cur, k);
        return newHead;
    }
    
	public ListNode reserveList(ListNode head, int k){
        ListNode left = null;
        ListNode right = head;
        ListNode tmp = null;
        int len = 0;
        while(len < k){
            tmp = right.next;
            right.next = left;
            left = right;
            right = tmp;
            len++;
        }
        return left;
    }
}
