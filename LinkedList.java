class Node {
    int number;
    Node next;

    Node(int number) {
        this.number = number;
    }
}

public class LinkedList {
    Node head, tail;

    /* 
        Methods: 

        void printList();
        void addToHead();
    */

    void printList() {
        System.out.println(head.number);
    }

    void addToHead(int number) {
        Node node = new Node(number);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}