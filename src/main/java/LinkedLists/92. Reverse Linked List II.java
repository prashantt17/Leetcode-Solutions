/*

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

*/

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode curr = head;
		ListNode leftList = null;
		ListNode rightList = null;

		int counter = 0;

		while (curr != null) {
			counter++;
			if (counter == left) {
				break;
			}
			leftList = curr;
			curr = curr.next;
		}

		ListNode leftListTemp = curr;
		while (curr != null) {
			if (counter == right) {
				break;
			}
			counter++;
			curr = curr.next;

		}

		rightList = curr.next;
		curr.next = null;

		leftListTemp = reverseLinkedList(leftListTemp);

		if (leftList == null) {
			head = leftListTemp;
		} else {
			leftList.next = leftListTemp;
		}

		while (leftListTemp.next != null) {
			leftListTemp = leftListTemp.next;
		}
		leftListTemp.next = rightList;

		return head;

	
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
