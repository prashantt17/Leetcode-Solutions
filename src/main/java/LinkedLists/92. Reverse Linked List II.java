/*

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

*/

class Solution {public ListNode reverseBetween(ListNode head, int left, int right) {
  if (left == right)
    return head;
  ListNode l = null, r = null, curr = head;
  int c = 0;
  while (curr != null) {
    c++;
    if (c == left)
      break;
    l = curr;
    curr = curr.next;
  }
  ListNode lt = curr;
  while (curr != null) {

    if (c == right)
      break;
    c++;
    curr = curr.next;
  }

  r = curr.next;
  curr.next = null;
  lt = reverseLinkedList(lt);
  if (l == null)
    head = lt;
  else
    l.next = lt;
  while (lt.next != null) {
    lt = lt.next;
  }
  lt.next = r;

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
