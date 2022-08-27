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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode list = head;
        
        ArrayList<Integer> sorting = new ArrayList<>();
        while(list != null){
            sorting.add(list.val);
            list = list.next;
        }
        Collections.sort(sorting);
        int i = 0;
        list = head;
        while(list != null){
            list.val = sorting.get(i);
            list = list.next;
            i++;
        }
        return head;
    }
}
