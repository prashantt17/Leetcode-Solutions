/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}

		Node cloneHead = null;
		Node cloneTail = null;

		Node temp = head;
		while (temp != null) {
			Node newNode = new Node(temp.val);
			if (cloneHead == null) {
				cloneHead = newNode;
				cloneTail = newNode;

			} else {
				cloneTail.next = newNode;
				cloneTail = newNode;
			}
			temp = temp.next;
		}

		HashMap<Node, Node> map = new HashMap<>();

		Node originalNode = head;
		Node cloneNode = cloneHead;

		while (originalNode != null && cloneNode != null) {
			map.put(originalNode, cloneNode);
			originalNode = originalNode.next;
			cloneNode = cloneNode.next;
		}

		originalNode = head;
		cloneNode = cloneHead;

		while (originalNode != null) {
			Node point = map.get(originalNode.random);
			if (point == null) {
				cloneNode.random = point;
			} else {
				cloneNode.random = point;
			}

			originalNode = originalNode.next;
			cloneNode = cloneNode.next;
		}

		return cloneHead;
	}
}
