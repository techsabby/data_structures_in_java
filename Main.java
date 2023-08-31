public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for (int i = 50; i >= 1; i--)
            linkedList.addToTail(i);

        System.out.println(linkedList.search(51));


    }
}