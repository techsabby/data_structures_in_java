public class Main {
    public static void main(String[] args) {
        
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addToHead(88);
        doubleLinkedList.addToHead(7);
        doubleLinkedList.addToHead(35);
        doubleLinkedList.addToHead(76);
        doubleLinkedList.addToHead(6);
        doubleLinkedList.addToTail(44);
        doubleLinkedList.addToTail(89);
        doubleLinkedList.addToTail(2);
        doubleLinkedList.addToTail(17);
        doubleLinkedList.printList();
        doubleLinkedList.printSize();
        doubleLinkedList.addToPosition(69, 4);
        doubleLinkedList.printList();
        doubleLinkedList.printSize();

    }
}