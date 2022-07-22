/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:

Input: head = [2,1], x = 2
Output: [1,2]

*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		
		ListNode leftHead = left;
		ListNode rightHead = right;
		
		while (head != null) {
			if (head.val < x) {
				leftHead.next = head;
				leftHead = leftHead.next;
			} else {
				rightHead.next = head;
				rightHead = rightHead.next;
			}
			head = head.next;
		}
		
		rightHead.next = null;
		leftHead.next = right.next;
		
		
		return left.next;
	
    }
}
