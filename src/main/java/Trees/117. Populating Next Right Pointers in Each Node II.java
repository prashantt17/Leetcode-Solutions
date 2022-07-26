/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

//In this approach first, we will create the dummy node and use the node's next pointer to traverse the tree horizontally.

//for each level, we will assign the dummy node to the left-most node and try to use the next pointer to move ahead and keep checking the node availability

//#############Here's the code for the above depicted solution:################//

  
public Node connect(Node root) {
	if (root == null) {
		return null;
	}

	Node head = root;
	while (head != null) {
		Node curr = new Node(-111);
		Node temp = curr;

		while (head != null) {

			if (head.left != null) {
				temp.next = head.left;
				temp = temp.next;
			}

			if (head.right != null) {
				temp.next = head.right;
				temp = temp.next;
			}
			head = head.next;
		}
		head = curr.next;
	}
	return root;
}
