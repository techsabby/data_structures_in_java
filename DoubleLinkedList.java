class DLLNode {
    int number, position;
    DLLNode next, prev;

    DLLNode() {}

    DLLNode(int number) {
        this.number = number;
    }
}

public class DoubleLinkedList {
    DLLNode head, tail;
    int size;

    void printSize() {
        System.out.println("List size: " + size);
    }

    void printNode(DLLNode node) {
        System.out.println("Position: " + node.position + " = [" + node.number + "]");
    }

    void printList() {
        if (size == 0) {
            System.out.println("Empty List."); 
        } else if (size == 1) {
            System.out.println(head.position + ":" + head.number);
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

    void updatePositions(DLLNode node) {
        DLLNode temp = node;

        // add exception if tail node (is this needed)

        while(temp.next != null) {
            temp.position++;
            temp = temp.next;
        }

        temp.position++;
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
        updatePositions(head);
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
        updatePositions(tail);
    }

    void addToPosition(int number, int position) {
        DLLNode traverseNode = head;
        DLLNode insertNode = new DLLNode(number);

        // add exeception for adding to head 

        while (traverseNode.position != position - 1) {
            traverseNode = traverseNode.next;
        }

        traverseNode.next.prev = insertNode;
        insertNode.next = traverseNode.next;
        traverseNode.next = insertNode;
        insertNode.prev = traverseNode;
        insertNode.position = insertNode.next.position;

        size++;
        updatePositions(insertNode.next);
    }
}