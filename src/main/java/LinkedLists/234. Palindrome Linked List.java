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
       ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
      fast = reverseList(slow);
        ListNode temp = head;
        while(fast!=slow){
            if(fast.val!=temp.val)return false;
            temp = temp.next;   
            fast=fast.next;
            }return true;
    }  
    
    
     ListNode reverseList(ListNode start){
        
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode temp = null;
        while(curr!=null){
            temp =curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev; 
    }
}
