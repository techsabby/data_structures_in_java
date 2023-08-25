#test

class Node {
    int number, position; 
    Node next;

    Node(int num, int pos) {
        number = num;
        pos = position;
        next = null;
    }
}

public class LinkedList {
    int size = 0; 
    Node head = new Node();
    Node tail = new Node();

    public void addToHead() {
        if (size == 0) {
            size = 1;
            head = tail = new Node(1, size);      
        }
    }
}

