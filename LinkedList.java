class SLLNode {
    int number;
    Node next;

    SLLNode() {}

    SLLNode(int number) {
        this.number = number;
    }
}

public class LinkedList {
    int size; 

    SLLNode head, tail;
    
    boolean search(int num) {
        
        int count = 0;
        SLLNode tmp = head;

        while (tmp.next != null) {

            if (tmp.number == num) 
                count = count + 1;
                
            tmp = tmp.next;
        }

        if (count > 0) 
            return true;
        else    
            return false;
    }

    void printList() {
        SLLNode tmp = head; 

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

    void printSize() {
        System.out.println("Size: " + size);
    }

    void lowHigh(int size) {
        int num;
        int tmpSize = size;
        Node tmp = head;

        for(int i = 1; i < tmpSize; i++) {
            if (tmp.number > tmp.next.number) {
                num = tmp.number;
                tmp.number = tmp.next.number;
                tmp.next.number = num;

                lowHigh(tmpSize - 1);
            }

            tmp = tmp.next;
        }
    }

    void highLow(int size) {
        int num;
        int tmpSize = size;
        Node tmp = head;

        for(int i = 1; i < tmpSize; i++) {
            if (tmp.number < tmp.next.number) {
                num = tmp.number;
                tmp.number = tmp.next.number;
                tmp.next.number = num;

                highLow(tmpSize -1);
            }

            tmp = tmp.next;
        }
    }

    void addToHead(int number) {
        Node node = new SLLNode(number);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size = size + 1;
    }

    void addToTail(int number) {
        Node node = new SLLNode(number);

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

        size = size + 1;
    }

    public void deleteFromHead() {
        if (head == null) {
            System.out.println("Empty List.");
        } else if (head.next == null) { 
            head = tail = null;
        } else if (head.next.next == null) {
            head = tail;
        } else {
            Node temp = new SLLNode();

            temp.next = head.next.next;
            temp.number = head.next.number;
            head = temp;
        }

        size = size - 1;
    }

    public void deleteFromTail() {
        if (head == null) {
            System.out.println("Empty List.");
        } else if (head.next == null) {
            head = tail = null;
        } else if (head.next.next == null) {
            tail = head;
        } else {
            Node temp = new SLLNode();

            temp = head;

            while (temp.next.next != null) {
                temp = temp.next;
            }
            
            tail = temp;
            tail.next = null;
        }

        size = size - 1;
    }
}