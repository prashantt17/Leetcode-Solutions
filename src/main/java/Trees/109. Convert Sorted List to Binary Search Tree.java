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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
         if (head == null) {
            return null;
        } else if (head.next == null) {
            TreeNode entry = new TreeNode(head.val);
            return entry;
        } else if (head.next.next == null) {
            TreeNode entry = new TreeNode(head.next.val);
            entry.left = new TreeNode(head.val);
            return entry;
        } else if (head.next.next.next == null) {
            TreeNode entry = new TreeNode(head.next.val);
            entry.left = new TreeNode(head.val);
            entry.right = new TreeNode(head.next.next.val);
            return entry;
        } else {
            ListNode slow = head, prev = null;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            TreeNode entry = new TreeNode(slow.val);
            prev.next = null;
            entry.left = sortedListToBST(head);
            entry.right = sortedListToBST(slow.next);
            return entry;
        }
    }
}
