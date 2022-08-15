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
    public ListNode deleteDuplicates(ListNode head) {
         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ListNode temp = head;
        
        while(temp!=null){
            map.put(temp.val, map.get(temp.val)!=null ? map.get(temp.val)+1 : 1);
            temp = temp.next;
        }
        
        temp = head;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while(temp!=null){
            if(map.get(temp.val)==1){
                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
        }
        
        return dummy.next;
    }
}
