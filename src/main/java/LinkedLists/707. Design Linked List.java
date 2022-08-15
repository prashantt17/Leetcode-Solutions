class MyLinkedList {

     class Node {
        int value;
        Node next;
        
        Node(int value){
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size){
            return -1;
        }
        Node node = head;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node.value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(null == tail){
            tail = head;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {        
        if(head == null){
            addAtHead(val);
            return;
        }

        tail.next = new Node(val);
        tail = tail.next; 
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == size){
            addAtTail(val);
            return;
        }
        Node node = head;
        Node newNode = new Node(val);
        while(null != node && index >1){
            node = node.next;
            index--;
        }
        newNode.next = node.next;
        node.next = newNode; 
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size){
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }
        Node node = head;
        while(null != node && index > 1){
            node = node.next;
            index--;
        }
        
        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
        size--;
    }
    
    public void deleteAtHead(){
        head = head.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
