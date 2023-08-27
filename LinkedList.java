class Node {
    int number;
    Node next;
}

public class LinkedList {
    Node head;
    Node tail;

    /*
        Methods:

        void printList();
        void printHeadTail();
        void addToHead(int number);
        void addToTail(int number);
        void deleteFromHead();
        void deleteFromTail();

    */

    public void printList() {
        Node tmp = head; 

        if (head == null) {
            System.out.println("Empty List.");
        } else if (head != null && head.next == null) {
            System.out.println("[" + head.number + "]");
        } else {
            while (tmp.next != null) {
                System.out.print("[" + tmp.number + "]");
                tmp = tmp.next;
            }

            System.out.println("[" + tmp.number + "]");
        }
    }

    public void printHeadTail() {
        if (head != null) {
            System.out.println("Head contains: " + head.number);
            System.out.println("Tail contains: " + tail.number);
        } else {
            System.out.println("Empty List.");
        }
    }    

    public void addToHead(int number) {
        Node node = new Node();
        node.number = number; 

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head; 
            head = node;
        }
    } 

    public void addToTail(int number) {
        Node node = new Node();
        node.number = number;

        if (head == null) {
            head = tail = node;
        } else {
            Node tmp = head;

            while(tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = node;
            tail = node;
        }
    }

    public void deleteFromHead() {
        if (head == null) {
            System.out.println("Empty List.");
        } else if (head.next == null) { 
            head = tail = null;
        } else if (head.next.next == null) {
            head = tail;
        } else {
            Node temp = new Node();

            temp.next = head.next.next;
            temp.number = head.next.number;
            head = temp;
        }
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("Empty List.");
        } else if (head.next == null) {
            head = tail = null;
        } else if (head.next.next == null) {
            tail = head;
        } else {
            Node temp = new Node();

            temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            
            tail = temp;
            tail.next = null;
        }
    }
}
