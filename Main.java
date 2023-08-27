public class Main {
    public static void main(String[] args) {
        int decider, randonum;
        LinkedList linkedlist = new LinkedList();

        for (int i = 1; i <= 50; i++) {
            decider = (int)Math.floor(Math.random() * (4 - 1 + 1) + 1);
            randonum = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
            
            if (decider == 1) 
                linkedlist.addToHead(randonum);
            else if (decider == 2) 
                linkedlist.addToTail(randonum);
            else if (decider == 3)
                linkedlist.deleteFromHead();
            else
                linkedlist.deleteFromHead();

            linkedlist.printList();
        }

        linkedlist.printHeadTail();
        linkedlist.printList();
    }
}