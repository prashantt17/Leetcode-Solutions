/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
        int len1 = length(headA);
        int len2 = length(headB);
       
        int absLen = Math.abs(len1 - len2);

        ListNode tempA = headA;
        ListNode tempB = headB;     
        
        
        if (len1 > len2) {
            while (absLen -- > 0) {
                tempA = tempA.next;
            }
        } else {
             while (absLen -- > 0) {
                tempB = tempB.next;
             }
        }
                        
      
        
         while (tempA != tempB) {
             tempA = tempA.next;
             tempB = tempB.next;
              if (tempA == null || tempB == null) return null;
         }                                                                          
        
        return tempA;
    }
    
    private int length (ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
