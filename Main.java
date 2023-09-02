public class Main {
    public static void main(String[] args) {
        
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        for(int i = 1; i <= 10; i++)
            doubleLinkedList.addToTail(i);

        doubleLinkedList.printList();

        doubleLinkedList.deleteFromPosition(10);

        doubleLinkedList.printList();


    }
}