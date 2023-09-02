class DLLNode {
    int number, position;
    DLLNode next, prev;

    DLLNode() {} // for initalizing temp instances of DLLNode 

    DLLNode(int number) {
        this.number = number;
    }
}

public class DoubleLinkedList {
    DLLNode head, tail;
    int size;

    /* 
        Methods (listed in order):

        Print: printSize() / printList() / printNode()
        Add: addToHead() / addToTail() / addToPosition()
        Delete: deleteFromHead() / deleteFromTail() / deleteFromPosition()
        Update: updatePositions()

    */

    void printSize() {
        System.out.println("List size: " + size);
    }

    void printList() {
        if (size == 0) {
            System.out.println("Empty List."); 
        } else if (size == 1) {
            printNode(head);
        } else {
            DLLNode temp = new DLLNode();

            temp = head;

            while(temp.next != null) {
                printNode(temp);
                temp = temp.next;
            }

            printNode(temp);
        }
    }

    void printNode(DLLNode node) {
        System.out.println("Position: " + node.position + " = [" + node.number + "]");
    }

    void addToHead(int number) {
        DLLNode temp = new DLLNode(number);
        if (size == 0) {
            head = tail = temp;

        } else {
            head.prev = temp;
            temp.next = head;
            head = temp;
        }

        size++;

        updatePositions(head, 1);
    }

    void addToTail(int number) {
        DLLNode temp = new DLLNode(number);

        if (size == 0) {
            head = tail = temp;

        } else {
            tail.next = temp;
            temp.prev = tail;
            temp.position = tail.position;
            tail = temp;
        }

        size++;
        updatePositions(tail, 1);
    }

    void addToPosition(int number, int position) {
        DLLNode traverseNode = head;
        DLLNode insertNode = new DLLNode(number);

        if (position == 1) {
            addToHead(number);
        } else if (position == (size + 1) || position > (size + 1)) {   // exception after || if user wants to add to position out of bounds 
            addToTail(number);
        } else {

            while (traverseNode.position != position - 1) {
                traverseNode = traverseNode.next;
            }

            traverseNode.next.prev = insertNode;
            insertNode.next = traverseNode.next;
            traverseNode.next = insertNode;
            insertNode.prev = traverseNode;
            insertNode.position = insertNode.next.position;

            size++;
            updatePositions(insertNode.next, 1);
        }
    }

    void deleteFromHead() {
        DLLNode temp = new DLLNode();
        temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null; // is deallocation needed in java? 
        temp = null;

        size--;
        updatePositions(head, 0);
    }

    void deleteFromTail() {
        DLLNode temp = new DLLNode();
        temp = tail; 
        tail = tail.prev;
        tail.next = null;
        temp.prev = null; // is deallocation needed in java? 
        temp = null;

        size --;
    }

    void deleteFromPosition(int position) {
        DLLNode traverseNode = head;

        if (position == 1) {
            deleteFromHead();
        } else if (position == size || position > size) {  
            deleteFromTail();
        } else { 

            while(traverseNode.position != position - 1 ) {
                traverseNode = traverseNode.next;
            }

            traverseNode.next = traverseNode.next.next;
            traverseNode.next.prev = traverseNode;

            updatePositions(traverseNode.next, 0);
        }
    }

    void updatePositions(DLLNode node, int increase) { // node passed can be head or any other node, 1 for increase and 0 for decrease 
        DLLNode temp = node;

        // add exception if tail node (is this needed?)

        if (increase == 1) {
            while(temp.next != null) {
                temp.position++;
                temp = temp.next;
            }

            temp.position++;
        } else {
            while(temp.next != null) {
                temp.position--;
                temp = temp.next;
            }

            temp.position--;
        }
    }
}